import { html } from "../lib.js";
import { getUserData } from "../util.js";
import { getItemsByUser } from "../api/operations.js";

//${____.length == 0 ? noElements() : ____.map(indivElement)}
const profileTemplate = (items, userData) => html`
<section id="profilePage">
    <div class="userInfo">
        <div class="avatar">
            <img src="./images/profilePic.png">
        </div>
        <h2>${userData.email}</h2>
    </div>
    <div class="board">
        
${items.length == 0 ? noElements() : items.map(indivElement)}

        
    </div>
</section>
`;

const indivElement = (item) => html`
<div class="eventBoard">
            <div class="event-info">
                <img src="${item.imageUrl}">
                <h2>${item.title}</h2>
                <h6>${item.date}</h6>
                <a href="/details/${item._id}" class="details-button">Details</a>
            </div>
        </div>
`;

const noElements = () => html`
<div class="no-events">
            <p>This user has no events yet!</p>
        </div>
`;

export async function profileView(ctx) {
  const userData = getUserData();
  const items = await getItemsByUser(userData.id);
  ctx.render(profileTemplate(items, userData));
}
