import  {html, nothing } from '../lib.js'
//import from obj search

//we may use template if similar to other view
const searchTemplate = () => html `

`;

//difference if it is a form or not easiest way is to add event listener click event  to the element by id or other attribute (take the value of the element)
export async function searchView(ctx) {
    ctx.render(searchTemplate()); 


    /*onClick func {
        const xxxx = await search

        ret to search template to render the result
    }*/
}