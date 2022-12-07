import { login } from '../api/user.js';
import { html } from '../lib.js';

//@submit=${onSumbit}
const loginTemplate = (onSumbit) => html`
<section @submit=${onSumbit} id="login-page" class="auth">
            <form id="login">
                <h1 class="title">Login</h1>

                <article class="input-group">
                    <label for="login-email">Email: </label>
                    <input type="email" id="login-email" name="email">
                </article>

                <article class="input-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password">
                </article>

                <input type="submit" class="btn submit-btn" value="Log In">
            </form>
        </section>

`;


export function loginView(ctx) {
    ctx.render(loginTemplate(onSumbit));
    async function onSumbit(e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const email = formData.get('email').trim();
        const password = formData.get('password').trim();

        if(email == '' || password == '') {
           return alert('All fields are required!');
        }

        await login(email, password);
        ctx.updateNav();
        ctx.page.redirect('/');
    }
}