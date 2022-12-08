import { getGameById, updateGame } from "../api/games.js";
//import { notify } from "../bonus/notify.js";
import { html } from "../lib.js";
//@submit=${onSubmit} + .value for all dynamic values
const editTemplate = (game, onSubmit) => html`
<section id="edit-page" class="auth">
    <form @submit=${onSubmit} id="edit">
        <div class="container">

            <h1>Edit Game</h1>
            <label for="leg-title">Legendary title:</label>
            <input type="text" id="title" name="title" value="" .value=${game.title}>

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" value="" .value=${game.category}>

            <label for="levels">MaxLevel:</label>
            <input type="number" id="maxLevel" name="maxLevel" min="1" value="" .value=${game.maxLevel}>

            <label for="game-img">Image:</label>
            <input type="text" id="imageUrl" name="imageUrl" value="" .value=${game.imageUrl}>

            <label for="summary">Summary:</label>
            <textarea name="summary" id="summary" .value=${game.summary}></textarea>
            <input class="btn submit" type="submit" value="Edit Game">

        </div>
    </form>
</section>
`;

export async function editView(ctx) {
  const game = await getGameById(ctx.params.id);
  ctx.render(editTemplate(game, onSubmit));

  async function onSubmit(e) {
    e.preventDefault();

    const formData = new FormData(e.target);

    const game = {
      title: formData.get('title'),
      category: formData.get('category'),
      maxLevel: formData.get('maxLevel'),
      imageUrl: formData.get('imageUrl'),
      summary: formData.get('summary')
  }

  if(game.title == '' || game.category == '' || game.maxLevel == '' || game.imageUrl == '' || game.summary == '') {
    return alert('All fields are required!');   
  }

        await updateGame(ctx.params.id, game);
        e.target.reset();
        ctx.page.redirect(`/details/${ctx.params.id}`);
  }
}
