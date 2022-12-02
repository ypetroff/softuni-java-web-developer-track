import { getItemById, updateItem } from "../api/operations.js";

import { html } from "../lib.js";


const editTemplate = (item, onSubmit) => html`
  <section id="edit">
    <div class="form">
      <h2>Edit Offer</h2>
      <form @submit=${onSubmit} class="edit-form">
        <input type="text" name="title" id="job-title" placeholder="Title" .value=${item.title} />
        <input
          type="text"
          name="imageUrl"
          id="job-logo"
          placeholder="Company logo url"
          .value=${item.imageUrl}
        />
        <input
          type="text"
          name="category"
          id="job-category"
          placeholder="Category"
          .value=${item.category}
        />
        <textarea
          id="job-description"
          name="description"
          placeholder="Description"
          rows="4"
          cols="50"
          .value=${item.description}
        ></textarea>
        <textarea
          id="job-requirements"
          name="requirements"
          placeholder="Requirements"
          rows="4"
          cols="50"
          .value=${item.requirements}
        ></textarea>
        <input type="text" name="salary" id="job-salary" placeholder="Salary" .value=${item.salary} />

        <button type="submit">post</button>
      </form>
    </div>
  </section>
`;

export async function editView(ctx) {
  const item = await getItemById(ctx.params.id);
  ctx.render(editTemplate(item, onSubmit));

  async function onSubmit(e) {
    e.preventDefault();

    const formData = new FormData(e.target);

    const item = {
      title: formData.get("title"),
      imageUrl: formData.get("imageUrl"),
      category: formData.get("category"),
      description: formData.get("description"),
      requirements: formData.get("requirements"),
      salary: formData.get("salary"),
    };

    if (
      item.title == "" ||
      item.description == "" ||
      item.imageUrl == "" ||
      item.category == "" ||
      item.requirements == "" ||
      item.salary == ""
    ) {
      return alert("All fields are required!");
    }

    await updateItem(ctx.params.id, item);
    e.target.reset();
    ctx.page.redirect(`/details/${ctx.params.id}`);
  }
}
