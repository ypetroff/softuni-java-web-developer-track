import { html, nothing } from "../lib.js";
import { deletePet, getPetById, requestForUserDonation, totalPetDonations, donateToPet } from "../api/pets.js";
import { getUserData } from "../util.js";

//${isOwner ? buttons(pet._id, onDelete) : nothing}
const detailsTemplate = (pet, isOwner, userData, onDelete, onDonation, hasDonated, totalDonations) => html`
 <section id="detailsPage">
    <div class="details">
        <div class="animalPic">
            <img src=${pet.image}>
        </div>
        <div>
            <div class="animalInfo">
                <h1>Name: ${pet.name}</h1>
                <h3>Breed: ${pet.breed}</h3>
                <h4>Age: ${pet.age}</h4>
                <h4>Weight: ${pet.weight}</h4>
                <h4 class="donation">Donation: ${totalDonations}$</h4>
            </div>

            <div class="actionBtn">
            ${isOwner ? buttons(pet._id, onDelete) : nothing}
            ${!isOwner && userData && !hasDonated ? donationBtn(pet._id, onDonation) : nothing}
            </div>
        </div>
    </div>
</section>
`;

const buttons = (id, onDelete) => html`
                <a href="/edit/${id}" class="edit">Edit</a>
                <a @click=${onDelete} href="javascript:void(0)" class="remove">Delete</a>                  
`;                                        //javascript:void(0)

const donationBtn = (id, onDonation) => html `
<a @click=${onDonation} href="/details/${id}" class="donate">Donate</a>    
`;

export async function detailsView(ctx) {
  const pet = await getPetById(ctx.params.id);
  const totalDonations = Number(await totalPetDonations(ctx.params.id)) * 100;
  const userData = getUserData();
  const hasDonated = userData?.id ? await requestForUserDonation(ctx.params.id, userData.id) : false;
  const isOwner = userData?.id == pet._ownerId;

  ctx.render(detailsTemplate(pet, isOwner, userData, onDelete, onDonation, hasDonated, totalDonations));

  async function onDonation() {

    const domation = {
      petId: ctx.params.id
    }

    await donateToPet(domation);
    detailsView
  //   const hasDonated = userData?.id ? await requestForUserDonation(ctx.params.id, userData.id) : false;
  // const totalDonations = Number(await totalPetDonations(ctx.params.id)) * 100;
  // ctx.render(detailsTemplate(pet, isOwner, userData, onDelete, onDonation, hasDonated, totalDonations));
  }
  async function onDelete() {
    const choise = confirm('Are you sure you want to delete this pet?');
    
    if(choise) {
      await deletePet(ctx.params.id);
      ctx.page.redirect('/');
    }
  }
}


