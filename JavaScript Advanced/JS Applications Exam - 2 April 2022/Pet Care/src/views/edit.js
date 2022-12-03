import { getPetById, updatePet } from "../api/pets.js";
//import { notify } from "../bonus/notify.js";
import { html } from "../lib.js";
//@submit=${onSubmit} + .value for all dynamic values
const editTemplate = (pet, onSubmit) => html`
<section id="editPage">
    <form @submit=${onSubmit} class="editForm">
        <img src=${pet.image}>
        <div>
            <h2>Edit PetPal</h2>
            <div class="name">
                <label for="name">Name:</label>
                <input name="name" id="name" type="text" value="Max" .value=${pet.name}>
            </div>
            <div class="breed">
                <label for="breed">Breed:</label>
                <input name="breed" id="breed" type="text" value="Shiba Inu" .value=${pet.breed}>
            </div>
            <div class="Age">
                <label for="age">Age:</label>
                <input name="age" id="age" type="text" value="2 years" .value=${pet.age}>
            </div>
            <div class="weight">
                <label for="weight">Weight:</label>
                <input name="weight" id="weight" type="text" value="5kg" .value=${pet.weight}>
            </div>
            <div class="image">
                <label for="image">Image:</label>
                <input name="image" id="image" type="text" value=${pet.image}>
            </div>
            <button class="btn" type="submit">Edit Pet</button>
        </div>
    </form>
</section>
`;

export async function editView(ctx) {
  const pet = await getPetById(ctx.params.id);
  ctx.render(editTemplate(pet, onSubmit));

  async function onSubmit(e) {
    e.preventDefault();

    const formData = new FormData(e.target);

     const pet = {
            name: formData.get('name'),
            breed: formData.get('breed'),
            age: formData.get('age'),
            weight: formData.get('weight'),
            image: formData.get('image'),
        }

        if(pet.name == '' || pet.breed == '' || pet.age == '' || pet.weight == '' || pet.image == '') {
         return alert('All fields are required!');  
        
        }

        await updatePet(ctx.params.id, pet);
        e.target.reset();
        ctx.page.redirect(`/catalog/${ctx.params.id}`);
  }
}
