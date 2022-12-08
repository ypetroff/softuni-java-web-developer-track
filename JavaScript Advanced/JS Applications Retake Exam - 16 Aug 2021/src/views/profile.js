import { html } from "../lib.js";
import { getUserData } from "../util.js";
import { getGameByUser } from "../api/games.js";

//${____.length == 0 ? noElements() : ____.map(indivElement)}
const profileTemplate = (games, userData) => html`

`;

const indivElement = (game) => html`

`;

/*const noElements = () => html`

`;*/

export async function profileView(ctx) {
  const userData = getUserData();
  const game = await getGameByUser(userData.id);
  ctx.render(profileTemplate(game, userData));
}
