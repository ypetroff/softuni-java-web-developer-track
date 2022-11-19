function addItem() {
    let inputText = document.getElementById('newItemText').value;
    let newLiElement = document.createElement('li');
    newLiElement.textContent = inputText;

    let ulListElement = document.getElementById('items');
    ulListElement.appendChild(newLiElement);
    document.getElementById('newItemText').value = '';
}