import { html } from "../lib.js";
import { getAllItems } from "../api/operations.js";

const catalogTemplate = (items) => html`
  <section id="dashboard">
    <h2>Job Offers</h2>

    ${items.length == 0
      ? html`<h2>No offers yet.</h2>`
      : items.map(individualElement)}
  </section>
`;

const individualElement = (item) => html`
  <div class="offer">
    <img src=${item.imageUrl} alt="./images/example3.png" />
    <p><strong>Title: </strong><span class="title">${item.title}</span></p>
    <p><strong>Salary:</strong><span class="salary">${item.salary}</span></p>
    <a class="details-btn" href="/details/${item._id}">Details</a>
  </div>
`;

export async function catalogView(ctx) {
  const items = await getAllItems();
  ctx.render(catalogTemplate(items));
}
