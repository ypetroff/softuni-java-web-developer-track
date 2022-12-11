import { html, nothing } from "../lib.js";
import { deleteItem, getItemById, getTotalLikes, isLikedByUser, likeItem } from "../api/operations.js";
import { getUserData } from "../util.js";

const detailsTemplate = (item, isOwner, userData, onDelete, onLike, totalLikes, isLiked) => html`
  <section id="detailsPage">
    <div id="detailsBox">
      <div class="detailsInfo">
        <h1>Title: ${item.title}</h1>
        <div>
          <img src="${item.imageUrl}" />
        </div>
      </div>

      <div class="details">
        <h3>Theater Description</h3>
        <p>${item.description}</p>
        <h4>Date: ${item.date}</h4>
        <h4>Author: ${item.author}</h4>
        <div class="buttons">
          ${isOwner ? buttons(item._id, onDelete) : nothing}
          ${!isOwner && userData?.id && !isLiked ? likeBtn(item._id, onLike) : nothing}
          
        </div>
        <p class="likes">Likes: ${totalLikes}</p>
      </div>
    </div>
  </section>
`;
//@click=${onDelete}
const buttons = (id, onDelete) => html`
  <a  @click=${onDelete} class="btn-delete" href="javascript:void(0)">Delete</a>
  <a class="btn-edit" href="/edit/${id}">Edit</a>
`;

const likeBtn = (id, onLike) => html`<a @click=${onLike} class="btn-like" href="/details/${id}">Like</a>`;

export async function detailsView(ctx) {
  const item = await getItemById(ctx.params.id);
  const userData = getUserData();
  const [isLiked, totalLikes] = await Promise.all([
    userData?.id ? isLikedByUser(ctx.params.id, userData.id) : false,
    getTotalLikes(ctx.params.id),
  ]);

  const isOwner = userData?.id == item._ownerId;
 

  ctx.render(detailsTemplate(item, isOwner, userData, onDelete, onLike, totalLikes, isLiked));

  async function onDelete() {
    const choise = confirm("Are you sure you want to delete this item?");

    if (choise) {
      await deleteItem(ctx.params.id);
      ctx.page.redirect("/");
    }
  }

  async function onLike() {
    const id = {
      theaterId: ctx.params.id
    }

    await likeItem(id);
    detailsView;
  }
}
