import { html } from '../lib.js';
import { getUserData } from '../util.js';


const homeTemplate = () => html`
`;


export function homeView(ctx) { //based on the task the redirect may be different
        ctx.render(homeTemplate());  
}