import { html, nothing } from "../lib.js";
import { getUserData } from "../util.js";
import { getBookByUser } from "../api/books.js";

//${____.length == 0 ? noElements() : ____.map(indivElement)}
const profileTemplate = (books) => html`
  <section id="my-books-page" class="my-books">
    <h1>My Books</h1>

    <ul class="my-books-list">
      ${books.length == 0 ? nothing : books.map(indivElement)}
    </ul>

    ${books.length == 0
      ? html`<p class="no-books">No books in database!</p>`
      : nothing}
  </section>
`;

const indivElement = (book) => html`
  <li class="otherBooks">
    <h3>${book.title}</h3>
    <p>Type: ${book.type}</p>
    <p class="img"><img src="${book.imageUrl}" /></p>
    <a class="button" href="/details/${book._id}">Details</a>
  </li>
`;

export async function profileView(ctx) {
  const userData = getUserData();
  const book = await getBookByUser(userData.id);
  ctx.render(profileTemplate(book));
}
