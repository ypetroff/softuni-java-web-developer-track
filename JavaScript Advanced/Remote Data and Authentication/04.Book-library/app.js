window.onload = addEventListeners;
const url = 'http://localhost:3030/jsonstore/collections/books/';
const loadAllBooksBtn = document.getElementById('loadBooks');
const table = document.querySelector('body > table > tbody');
const sumbitSaveBtn = document.querySelector('body > form > button');
const titleElement = document.querySelector('body > form > input[type=text]:nth-child(3)');
const authorElement = document.querySelector('body > form > input[type=text]:nth-child(5)');
const formTitleElement= document.querySelector('body > form > h3');
let id = '';


function addEventListeners() {
    loadAllBooksBtn.addEventListener('click', loadAllBooks);
    sumbitSaveBtn.addEventListener('click', createOrEditeBook)
}



async function loadAllBooks() {
    
    const res = await fetch(url);
    const data = await res.json();
    const fragment = document.createDocumentFragment();
    Object.entries(data)
    .map(([key,{author, title}]) => createRow(key, author, title))
    .forEach(row => fragment.appendChild(row));

    table.replaceChildren(fragment);
}

async function createOrEditeBook(e) {
    e.preventDefault();
    try {
    if(titleElement.textContent == '' || authorElement == '') {
        throw new Error ('Both fields should be filled');
    }

    const book = {
        author: authorElement.value,
        title: titleElement.value
    }


    if(e.target.textContent == 'Submit') {
    
        createBook(book);
      
    } else if(e.target.textContent == 'Save') {
        e.target.textContent = 'Sumbit';
        formTitleElement.textContent = 'FORM';

        saveBook(book);
    }

} catch(err) {
 alert(err.message)
}



    authorElement.value = '';
    titleElement.value = '';

    //loadAllBooks(); //for dynamically update of the table content
}

async function createBook(book) {
   
    await fetch(url, {
        method: 'post',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(book)
    })
}

async function saveBook(book) {
    await fetch(`${url}${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(book)
    });
}
function createRow(key, author, title){
    const row = document.createElement('tr');
    row.setAttribute('id', key)

    const firstCellElement = row.insertCell(0);
    firstCellElement.textContent = title;

    const secondCellElement = row.insertCell(1);
    secondCellElement.textContent = author;

    const editBtn = createBtn('Edit', editBook); /// check the f and how it is added

    const delBtn = createBtn('Delete', deleteBook); /// check the f and how it is added

    const thirdCell = row.insertCell(2);
    thirdCell.appendChild(editBtn);
    thirdCell.appendChild(delBtn);

    return row;
}

function createBtn(text, callback) {
 const btn = document.createElement('button');
 btn.textContent = text;
 btn.addEventListener('click', callback);
 return btn;
}

async function editBook(e) {

    formTitleElement.textContent = 'Edit FORM';
    sumbitSaveBtn.textContent = 'Save'

    const row = e.target.parentElement.parentElement;
    id = row.id;
    titleElement.value = row.firstChild.textContent;
    authorElement.value = row.getElementsByTagName('td')[1].textContent;
}

  function deleteBook(e) {
    fetch(url + e.target.parentElement.parentElement.id, {
        method: 'DELETE'
     });
    // loadAllBooks(); // dynamically update the table
}
