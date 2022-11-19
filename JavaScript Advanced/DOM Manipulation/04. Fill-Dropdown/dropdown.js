function addItem() {
 
        const newItemText = document.querySelector('#newItemText');
        const newItemValue = document.querySelector('#newItemValue');
    
        const newOption = document.createElement('option');
        newOption.value = newItemValue.value;
        newOption.textContent = newItemText.value;

       document.querySelector('#menu').appendChild(newOption);

       newItemText.value = '';
       newItemValue.value = '';

}