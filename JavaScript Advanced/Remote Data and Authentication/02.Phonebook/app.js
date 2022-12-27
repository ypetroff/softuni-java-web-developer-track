const url = "http://localhost:3030/jsonstore/phonebook";
const phonebookContactsList = document.getElementById("phonebook");

function attachEvents() {
  document.getElementById("btnLoad").addEventListener("click", loadContacts);
  document.getElementById("btnCreate").addEventListener("click", addNewContact);
}

async function addNewContact() {
const person = document.getElementById('person');
const phone = document.getElementById('phone');

try {

if(person.value == '' || phone.value == '') {
  throw new Error('Both fields are mandatory');
}
  const data = {
    person: person.value, 
    phone: phone.value
  };

  person.value = '';
  phone.value = '';


  await fetch(url, {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(data),
  });
} catch(err) {
 alert(err.message);
}
}

async function loadContacts() {
  phonebookContactsList.replaceChildren();
  const res = await fetch(url);
  const data = await res.json();

  Object.values(data)
    .map(({ person, phone, _id }) =>
      createLiElement("li", "id", _id, `${person}: ${phone}`)
    )
    .forEach((x) => phonebookContactsList.appendChild(x));
}

function createLiElement(type, attrType, attrText, content) {
  const element = document.createElement(type);
  element.setAttribute(attrType, attrText);
  element.textContent = content;

  const deleteBtn = document.createElement("button");
  deleteBtn.textContent = "Delete";
  deleteBtn.addEventListener("click", deleteContact);
  element.appendChild(deleteBtn);
  return element;
}

async function deleteContact(e) {
  const contact = e.target.parentElement;
  const _id = contact.id;

  await fetch(`${url}/${_id}`, {
    method: "DELETE",
  });

  contact.remove();
}

attachEvents();
