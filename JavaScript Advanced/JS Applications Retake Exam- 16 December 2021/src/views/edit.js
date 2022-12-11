import { getItemById, updateItem } from "../api/operations.js";
//import { notify } from "../bonus/notify.js";
import { html } from "../lib.js";


//@submit=${onSubmit} + .value for all dynamic values
const editTemplate = (item, onSubmit) => html`
<section id="editPage">
    <form @submit=${onSubmit} class="theater-form">
        <h1>Edit Theater</h1>
        <div>
            <label for="title">Title:</label>
            <input id="title" name="title" type="text" placeholder="Theater name" value="To Kill A Mockingbird" .value=${item.title}>
        </div>
        <div>
            <label for="date">Date:</label>
            <input id="date" name="date" type="text" placeholder="Month Day, Year" value="December 13, 2018" .value=${item.date}>
        </div>
        <div>
            <label for="author">Author:</label>
            <input id="author" name="author" type="text" placeholder="Author"
                value="Aaron Sorkin, Fred Fordham" .value=${item.author}>
        </div>
        <div>
            <label for="description">Theater Description:</label>
            <textarea id="description" name="description"
                placeholder="Description" .value=${item.description}>To Kill a Mockingbird is a 2018 play based on the 1960 novel of the same name by Harper Lee, adapted for the stage by Aaron Sorkin. It opened on Broadway at the Shubert Theatre on December 13, 2018. The play is set to transfer to London's West End at the Gielgud Theatre in March 2022.</textarea>
        </div>
        <div>
            <label for="imageUrl">Image url:</label>
            <input id="imageUrl" name="imageUrl" type="text" placeholder="Image Url"
                value="./images/Moulin-Rouge!-The-Musical.jpg" .value=${item.imageUrl}>
        </div>
        <button class="btn" type="submit">Submit</button>
    </form>
</section>
`;

export async function editView(ctx) {
  const item = await getItemById(ctx.params.id);
  ctx.render(editTemplate(item, onSubmit));

  async function onSubmit(e) {
    e.preventDefault();

    const formData = new FormData(e.target);

    const item = { //fields may differ check also edit and user
      title: formData.get('title'),
      date: formData.get('date'),
      author: formData.get('author'),
      imageUrl: formData.get('imageUrl'),
      description: formData.get('description'),
  }

  if(item.title == '' || item.date == '' || item.author == '' || item.description == '' || item.imageUrl == '') {
    return alert('All fields are required!');   
  }

        await updateItem(ctx.params.id, item);
        e.target.reset();
        ctx.page.redirect(`/details/${ctx.params.id}`);
  }
}
