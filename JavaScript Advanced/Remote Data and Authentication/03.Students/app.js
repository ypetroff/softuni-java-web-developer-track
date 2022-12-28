window.onload = populateTable;

const url = 'http://localhost:3030/jsonstore/collections/students';
const table = document.querySelector('#results > tbody');
document.getElementById('submit').addEventListener('click', addStudent);

async function populateTable() {
    const res = await fetch(url);
    const data = await res.json();


    Object.values(data)
    .map(({firstName, lastName, facultyNumber, grade}) => createRow(firstName, lastName, facultyNumber, grade))
    .forEach(row => table.appendChild(row));

}

    

async function addStudent(e) {
    e.preventDefault();

    const firstNameElement = document.querySelector('[name="firstName"]');
    const lasttNameElement = document.querySelector('[name="lastName"]');
    const facultyNumberElement = document.querySelector('[name="facultyNumber"]');
    const gradeElement = document.querySelector('[name="grade"]');

    const firstName = firstNameElement.value;
    const lastName = lasttNameElement.value;
    const facultyNumber = facultyNumberElement.value;
    const grade = gradeElement.value;

    firstNameElement.value = '';
    lasttNameElement.value = '';
    facultyNumberElement.value = '';
    gradeElement.value = '';
    try {
    if(firstName == '' || lastName == '' || isNaN(facultyNumber) || isNaN(grade)) {
        throw new Error('Incorrectly filled data!');
    }

    await fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({firstName, lastName, facultyNumber, grade})
    });

    table.appendChild(createRow(firstName, lastName, facultyNumber, grade));
} catch(err) {
    alert(err.message);
}
}

function createRow(firstName, lastName, facultyNumber, grade) {
    const row = document.createElement('tr');

    const firstNameCell = row.insertCell(0);
    firstNameCell.textContent = firstName;

    const lastNameCell = row.insertCell(1);
    lastNameCell.textContent = lastName;

    const facultyNumberCell = row.insertCell(2); 
    facultyNumberCell.textContent = facultyNumber;

    const gradeNameCell = row.insertCell(3); 
    gradeNameCell.textContent = grade;

    return row;
}