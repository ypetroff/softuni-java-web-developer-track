import { html, nothing } from "../lib.js";
import {
  deleteGame,
  getGameById,
  loadComments,
  commentSubmission,
} from "../api/games.js";
import { getUserData } from "../util.js";

//${isOwner ? buttons(____._id, onDelete) : nothing}
const detailsTemplate = (
  game,
  isOwner,
  userData,
  comments,
  onDelete,
  onComment
) => html`
   <section id="game-details">
            <h1>Game Details</h1>
            <div class="info-section">

                <div class="game-header">
                    <img class="game-img" src="${game.imageUrl}" />
                    <h1>${game.title}</h1>
                    <span class="levels">MaxLevel: ${game.maxLevel}</span>
                    <p class="type">${game.category}</p>
                </div>

                <p class="text">
                ${game.summary}
                </p>

              
                <div class="details-comments">
                    <h2>Comments:</h2>
                    <ul>
                        ${comments.length != 0
                        ? comments.map(commentTemplate)
                      :nothing}
                    </ul>
                  
                    ${comments.length == 0
                    ? html `<p class="no-comment">No comments.</p>`
                  : nothing}
                    
                </div>

                ${isOwner ? buttons(game._id, onDelete) : nothing}
            </div>

            ${!isOwner && userData
            ? commentSectionTemplate(onComment)
          :nothing}
        </section>
`;

const buttons = (id, onDelete) => html`
  <div class="buttons">
    <a href="/edit/${id}" class="button">Edit</a>
    <a @click=${onDelete} href="javascript:void(0)" class="button">Delete</a>
  </div>
`;

const commentSectionTemplate = (onComment) => html`
  <article class="create-comment">
    <label>Add new comment:</label>
    <form @submit=${onComment} class="form">
      <textarea name="comment" placeholder="Comment......"></textarea>
      <input class="btn submit" type="submit" value="Add Comment" />
    </form>
  </article>
`;

const commentTemplate = (comment) => html`
  <li class="comment">
    <p>${comment.comment}</p>
  </li>
`;

export async function detailsView(ctx) {
  const game = await getGameById(ctx.params.id);
  const userData = getUserData();
  const isOwner = userData?.id == game._ownerId;
  const comments = await loadComments(ctx.params.id);

  ctx.render(
    detailsTemplate(game, isOwner, userData, comments, onDelete, onComment)
  );

  async function onDelete() {
    const choise = confirm("Are you sure you want to delete this game?");

    if (choise) {
      await deleteGame(ctx.params.id);
      ctx.page.redirect("/");
    }
  }

  function onComment(e) {
    e.preventDefault();
    const formData = new FormData(e.target);

    const comment = formData.get("comment").trim();

    if (comment == "") {
      return alert("Comment cannot be an empty string!");
    }

    const c = {
      gameId: ctx.params.id,
      comment,
    };
    commentSubmission(c);
    e.target.reset();
    ctx.page.redirect(`/details/${ctx.params.id}`);
  }
}
