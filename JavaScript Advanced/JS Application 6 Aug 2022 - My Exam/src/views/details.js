import { html, nothing } from "../lib.js";
import {
  applyItem,
  deleteItem,
  getItemById,
  getTotalApplications,
  isAppliedByUser,
} from "../api/operations.js";
import { getUserData } from "../util.js";

const detailsTemplate = (
  item,
  isOwner,
  userData,
  onDelete,
  onApplication,
  totalAplications,
  hasApplied
) => html`
  <section id="details">
    <div id="details-wrapper">
      <img id="details-img" src="${item.imageUrl}" alt="example1" />
      <p id="details-title">${item.title}</p>
      <p id="details-category">
        Category: <span id="categories">${item.category}</span>
      </p>
      <p id="details-salary">Salary: <span id="salary-number">${item.salary}</span></p>
      <div id="info-wrapper">
        <div id="details-description">
          <h4>Description</h4>
          <span
            >${item.description}</span
          >
        </div>
        <div id="details-requirements">
          <h4>Requirements</h4>
          <span
            >${item.requirements}</span
          >
        </div>
      </div>
      <p>Applications: <strong id="applications">${totalAplications}</strong></p>

      
      <div id="action-buttons">
        ${isOwner ? buttons(item._id, onDelete) : nothing}

        
        ${!isOwner && userData?.id && !hasApplied
          ? applyBtn(item._id, onApplication)
          : nothing}
      </div>
    </div>
  </section>
`;

const buttons = (id, onDelete) => html`
  <a href="/edit/${id}" id="edit-btn">Edit</a>
  <a @click=${onDelete} href="javascript:void(0)" id="delete-btn">Delete</a>
`;

const applyBtn = (id, onApplication) => html`
  <a @click=${onApplication} href="/details/${id}" id="apply-btn">Apply</a>
`;

export async function detailsView(ctx) {
  const item = await getItemById(ctx.params.id);
  const userData = getUserData();
  const isOwner = userData?.id == item._ownerId;

  const [hasApplied, totalAplications] = await Promise.all([
    userData?.id ? isAppliedByUser(ctx.params.id, userData.id) : false,
    getTotalApplications(ctx.params.id),
  ]);

  ctx.render(
    detailsTemplate(
      item,
      isOwner,
      userData,
      onDelete,
      onApplication,
      totalAplications,
      hasApplied
    )
  );

  async function onDelete() {
    const choise = confirm("Are you sure you want to delete this item?");

    if (choise) {
      await deleteItem(ctx.params.id);
      ctx.page.redirect("/catalog");
    }
  }

  async function onApplication() {
    const id = {
      offerId: ctx.params.id,
    };

    await applyItem(id);
    detailsView;
  }
}
