import { html } from "../lib.js";
import { getUserData } from "../util.js";
import { getPostsByUser } from "../api/posts.js";

//${____.length == 0 ? noElements() : ____.map(indivElement)}
const profileTemplate = (posts) => html`
     <section id="my-posts-page">
            <h1 class="title">My Posts</h1>

            ${posts.length == 0 ? noElements() : posts.map(indivElement)}
            
        </section>
`;

const indivElement = (post) => html`
 <div class="my-posts">
                <div class="post">
                    <h2 class="post-title">${post.title}</h2>
                    <img class="post-image" src=${post.imageUrl} alt="Material Image">
                    <div class="btn-wrapper">
                        <a href="/details/${post._id}" class="details-btn btn">Details</a>
                    </div>
                </div>
`;

const noElements = () => html`
<h1 class="title no-posts-title">You have no posts yet!</h1>
`;

export async function profileView(ctx) {
  const userData = getUserData();
  const posts = await getPostsByUser(userData.id);
  ctx.render(profileTemplate(posts));
}
