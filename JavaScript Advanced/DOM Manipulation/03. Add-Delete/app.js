function addItem() {
    let inputElement = document.getElementById('newItemText');
    let newLiElement = document.createElement('li');
    newLiElement.textContent = inputElement.value;

    let deleteButton = document.createElement('a');
    deleteButton.textContent = '[Delete]';
    // create method for optimisation?
    deleteButton.href = '#';
    deleteButton.addEventListener('click', () => {
        newLiElement.remove()
    });

    newLiElement.appendChild(deleteButton);


    let liElements = document.getElementById('items');
    liElements.appendChild(newLiElement);
    document.getElementById('newItemText').value = '';
}