import {page, render} from './lib.js';
//import { homeView } from './views/home.js';
import { catalogView } from './views/catalog.js';
import { detailsView } from './views/details.js';
import { editView } from './views/edit.js';
import { loginView } from './views/login.js';
import { registerView } from './views/register.js';
import { logout } from './api/user.js';
import { createView } from './views/create.js';
import { profileView } from './views/profile.js';
import { getUserData } from './util.js';

const main = document.querySelector('#main-content');

document.getElementById('logoutBtn').addEventListener('click', onLogout); //this id was added to the original HTML

page(decorateContext);
//page('/catalog', homeView);
page('/', catalogView);
page('/catalog/:id', detailsView);
page('/details/:id', detailsView);
page('/edit/:id', editView);
page('/login', loginView);
page('/register', registerView);
page('/create', createView);
page('/profile', profileView);
//page('/search', searchView); //depending on the rout it could be placed higher

updateNav();
page.start();

export function decorateContext(ctx, next) {
    ctx.render = renderMain;
    ctx.updateNav = updateNav;

    next();
}

function renderMain(templateResult) {
    render(templateResult, main);
}

function updateNav() { //for manual logout clear the sessionStorage
    const userData = getUserData();
// id or class may be different
    if(userData) {
        document.querySelector('#user').style.display = 'block';
        document.querySelector('#guest').style.display = 'none';
    }else {
        document.querySelector('#user').style.display = 'none';
        document.querySelector('#guest').style.display = 'block';
    }
}

function onLogout() {
    logout();
    updateNav();
    page.redirect('/');

}
