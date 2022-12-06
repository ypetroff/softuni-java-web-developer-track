import { html, nothing } from "../lib.js";
import { deleteMeme, getMemeById } from "../api/memes.js";
import { getUserData } from "../util.js";
 
const detailsTemplate = (meme, isOwner, onDelete) => html`
  <section id="meme-details">
    <h1>Meme Title: ${meme.title}</h1>
    <div class="meme-details">
      <div class="meme-img">
        <img alt="meme-alt" src=${meme.imageUrl} />
      </div>
      <div class="meme-description">
        <h2>Meme Description</h2>
        <p>${meme.description}</p>

        ${isOwner ? buttons(meme._id, onDelete) : nothing}
      </div>
    </div>
  </section>
`;

const buttons = (id, onDelete) => html`
  <a class="button warning" href="/edit/${id}">Edit</a>
  <button @click=${onDelete} class="button danger">Delete</button>
`;

export async function detailsView(ctx) {
  const meme = await getMemeById(ctx.params.id);
  const userData = getUserData();
  const isOwner = userData?.id == meme._ownerId;
  ctx.render(detailsTemplate(meme, isOwner, onDelete));

  async function onDelete() {
    const choise = confirm('Are you sure you want to delete this meme?');
    
    if(choise) {
      await deleteMeme(ctx.params.id);
      ctx.page.redirect('/memes');
    }
  }
}


