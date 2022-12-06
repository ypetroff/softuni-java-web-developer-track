import { notify } from '../bonus/notify.js';
import { register } from '../api/user.js';
import { html } from '../lib.js';


const registerTemplate = (onSumbit) => html`
<section @submit=${onSumbit} id="register">
            <form id="register-form">
                <div class="container">
                    <h1>Register</h1>
                    <label for="username">Username</label>
                    <input id="username" type="text" placeholder="Enter Username" name="username">
                    <label for="email">Email</label>
                    <input id="email" type="text" placeholder="Enter Email" name="email">
                    <label for="password">Password</label>
                    <input id="password" type="password" placeholder="Enter Password" name="password">
                    <label for="repeatPass">Repeat Password</label>
                    <input id="repeatPass" type="password" placeholder="Repeat Password" name="repeatPass">
                    <div class="gender">
                        <input type="radio" name="gender" id="female" value="female">
                        <label for="female">Female</label>
                        <input type="radio" name="gender" id="male" value="male" checked>
                        <label for="male">Male</label>
                    </div>
                    <input type="submit" class="registerbtn button" value="Register">
                    <div class="container signin">
                        <p>Already have an account?<a href="/login">Sign in</a>.</p>
                    </div>
                </div>
            </form>
        </section>`;


export function registerView(ctx) {
    ctx.render(registerTemplate(onSumbit));
//fields may be different
    async function onSumbit(e) {
        e.preventDefault();
        const formData = new FormData(e.target);

        const username = formData.get('username').trim();
        const email = formData.get('email').trim();
        const password = formData.get('password').trim();
        const repass = formData.get('repeatPass').trim();
        const gender = formData.get('gender');
        
        if(username == '' || email == '' || password == '') {
        //pre-bonus   return alert('All fields are required!');
           return notify('All fields are required!');
        }

        if(password != repass) {
        //pre-bonus    return alert('Passwords don\'t match');
            return notify('Passwords don\'t match');
        }

        await register(username, email, password, gender);
        ctx.updateNav();
        ctx.page.redirect('/memes');
    }
}