import { html, nothing } from "../lib.js";
import { deletePost, getPostById, getTotalDonations, didUserDonated, userDonate } from "../api/posts.js";
import { getUserData } from "../util.js";


//${isOwner ? buttons(post._id, onDelete) : nothing}
const detailsTemplate = (post, isOwner, userData, onDelete, onSubmit, hasDonated, getTotalDonations) => html`
  <section id="details-page">
            <h1 class="title">Post Details</h1>

            <div id="container">
                <div id="details">
                    <div class="image-wrapper">
                        <img src=${post.imageUrl} alt="Material Image" class="post-image">
                    </div>
                    <div class="info">
                        <h2 class="title post-title">${post.title}</h2>
                        <p class="post-description">Description: ${post.description}</p>
                        <p class="post-address">Address: ${post.address}</p>
                        <p class="post-number">Phone number: ${post.phone}</p>
                        <p class="donate-Item">Donate Materials: ${getTotalDonations}</p>

                        <div class="btns">
                        ${isOwner 
                          ? html` <a href="/edit/${post._id}" class="edit-btn btn">Edit</a>
                            <a href="javascript:void(0)" @click=${onDelete} class="delete-btn btn">Delete</a>` 
                            : nothing}

                            ${!isOwner && userData && !hasDonated 
                              ? html `<a href="/details/${post._id}" @click=${onSubmit} class="donate-btn btn">Donate</a>` 
                              : nothing}
                            
                        </div>

                    </div>
                </div>
            </div>
        </section>

`;


export async function detailsView(ctx) {

  const post = await getPostById(ctx.params.id);
 
  const donations = await getTotalDonations(ctx.params.id);
  
  const userData = getUserData();

  let hasDonated;
  if(userData) {
    hasDonated = await didUserDonated(ctx.params.id, userData.id);
  }
  const isOwner = userData?.id == post._ownerId;

  ctx.render(detailsTemplate(post, isOwner, userData, onDelete, onSubmit, hasDonated, donations));

  async function onDelete() {
    const choise = confirm("Are you sure you want to delete this post?");

    if (choise) {
      await deletePost(ctx.params.id);
      ctx.page.redirect('/');
    }
  }

  async function onSubmit() {

    const donation = {
      postId: ctx.params.id
    } 

    await userDonate(donation);

    hasDonated = await didUserDonated(ctx.params.id, userData.id);
    const donations = await getTotalDonations(ctx.params.id);
    ctx.render(detailsTemplate(post, isOwner, userData, onDelete, onSubmit, hasDonated, donations));
  }

}
