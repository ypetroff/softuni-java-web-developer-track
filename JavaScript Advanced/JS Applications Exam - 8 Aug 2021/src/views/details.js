import { html, nothing } from "../lib.js";
import {
  deleteBook,
  getBookById,
  verifyIfLiked,
  totalLikes,
  likeBook,
} from "../api/books.js";
import { getUserData } from "../util.js";

//${isOwner ? buttons(____._id, onDelete) : nothing}
const detailsTemplate = (
  book,
  isOwner,
  userData,
  onClick,
  onDelete,
  isLiked,
  currentLikes
) => html`
  <section id="details-page" class="details">
    <div class="book-information">
      <h3>${book.title}</h3>
      <p class="type">Type: ${book.type}</p>
      <p class="img"><img src=${book.imageUrl} /></p>
      <div class="actions">
        ${isOwner ? buttons(book._id, onDelete) : nothing}
        ${!isOwner && userData && !isLiked
          ? html`<a @click=${onClick} class="button" href="/details/${book._id}"
              >Like</a
            >`
          : nothing}

        <div class="likes">
          <img class="hearts" src="/images/heart.png" />
          <span id="total-likes">Likes: ${currentLikes}</span>
        </div>
        <!-- Bonus -->
      </div>
    </div>
    <div class="book-description">
      <h3>Description:</h3>
      <p>${book.description}</p>
    </div>
  </section>
`;

const buttons = (id, onDelete) => html`
  <a class="button" href="/edit/${id}">Edit</a>
  <a @click=${onDelete} class="button" href="javascript:void(0)">Delete</a>
`;

export async function detailsView(ctx) {
  const book = await getBookById(ctx.params.id);
  const userData = getUserData();
  const [isLiked, currentLikes] = await Promise.all([
    userData?.id ? verifyIfLiked(userData.id, ctx.params.id) : false,
    totalLikes(ctx.params.id),
  ]);

  const isOwner = userData?.id == book._ownerId;
  ctx.render(
    detailsTemplate(
      book,
      isOwner,
      userData,
      onClick,
      onDelete,
      isLiked,
      currentLikes
    )
  );

  async function onClick() {
    const id = {
      bookId: ctx.params.id,
    };
    await likeBook(id);
    detailsView;
  }

  async function onDelete() {
    const choise = confirm("Are you sure you want to delete this book?");
    if (choise) {
      await deleteBook(ctx.params.id);
      ctx.page.redirect("/");
    }
  }
}
