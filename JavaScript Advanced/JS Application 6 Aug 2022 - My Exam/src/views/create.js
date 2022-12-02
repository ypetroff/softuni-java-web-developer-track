import { html } from "../lib.js";
import { createItem } from "../api/operations.js";

const createTemplate = (onSubmit) => html`
  <section id="create">
    <div class="form">
      <h2>Create Offer</h2>
      <form @submit=${onSubmit} class="create-form">
        <input type="text" name="title" id="job-title" placeholder="Title" />
        <input
          type="text"
          name="imageUrl"
          id="job-logo"
          placeholder="Company logo url"
        />
        <input
          type="text"
          name="category"
          id="job-category"
          placeholder="Category"
        />
        <textarea
          id="job-description"
          name="description"
          placeholder="Description"
          rows="4"
          cols="50"
        ></textarea>
        <textarea
          id="job-requirements"
          name="requirements"
          placeholder="Requirements"
          rows="4"
          cols="50"
        ></textarea>
        <input type="text" name="salary" id="job-salary" placeholder="Salary" />

        <button type="submit">post</button>
      </form>
    </div>
  </section>
`;

export function createView(ctx) {
  ctx.render(createTemplate(onSubmit));

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

    await createItem(item);
    e.target.reset();
    ctx.page.redirect("/catalog");
  }
}
