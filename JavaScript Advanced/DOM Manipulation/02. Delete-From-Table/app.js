function deleteByEmail() {

    let inputTextElement = document.querySelector('input[name=email]').value;
    let tableElements = [...document.querySelectorAll('#customers > tbody > tr')];
   let resultOutput =  document.getElementById('result');
   resultOutput.textContent = 'Not found.'
                            // vvvvvvvv or lastElementChild
    tableElements.filter(x => x.cells[1].textContent === inputTextElement).forEach(x => {
        x.parentNode.removeChild(x);
        resultOutput.textContent = 'Deleted.'
    });

    document.querySelector('input[name=email]').value = '';
}