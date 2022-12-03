import {page, render} from './lib.js';
import { homeView } from './views/home.js';
import { catalogView } from './views/catalog.js';
import { detailsView } from './views/details.js';
import { editView } from './views/edit.js';
import { loginView } from './views/login.js';
import { registerView } from './views/register.js';
import { logout } from './api/user.js';
import { createView } from './views/create.js';
import { getUserData } from './util.js';

const elementsViewedByLoggerUser = [...document.querySelectorAll('.user')];
const elementsViewedByAnonymosUser = [...document.querySelectorAll('.guest')];

const main = document.querySelector('#content');

document.getElementById('logoutBtn').addEventListener('click', onLogout); //this id was added to the original HTML

page(decorateContext);
page('/', homeView);
page('/catalog', catalogView);
page('/details/:id', detailsView);
page('/edit/:id', editView);
page('/login', loginView);
page('/register', registerView);
page('/create', createView);



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
        elementsViewedByLoggerUser.map(x => x.style.display = 'block');
        elementsViewedByAnonymosUser.map(x => x.style.display = 'none');
    }else {
        elementsViewedByLoggerUser.map(x => x.style.display = 'none');
        elementsViewedByAnonymosUser.map(x => x.style.display = 'block');
    }
}

function onLogout() {
    logout();
    updateNav();
    page.redirect('/');

}
