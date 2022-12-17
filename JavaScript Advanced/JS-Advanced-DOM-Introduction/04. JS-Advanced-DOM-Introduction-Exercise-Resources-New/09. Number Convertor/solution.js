function solve() {

    let selectMenuConvertToElement = document.getElementById('selectMenuTo');

    addOptionsElements();

let convertor = {
    binary: (x) => x.toString(2),
    hexadecimal: (x) => x.toString(16).toUpperCase(),
};


document.querySelector('#container > button').addEventListener('click', convert);

function convert() {
    let inputDecimal = document.getElementById('input').value;

    document.getElementById('result').value = convertor[selectMenuConvertToElement.value](Number(inputDecimal));
}

    function addOptionsElements() {
        let binaryOptionElement = document.createElement('option');
        binaryOptionElement.textContent = 'Binary';
        binaryOptionElement.value = 'binary';

        let hexadecimalOprionElement = document.createElement('option');
        hexadecimalOprionElement.textContent = 'Hexadecimal';
        hexadecimalOprionElement.value = 'hexadecimal';

        selectMenuConvertToElement.add(binaryOptionElement);
        selectMenuConvertToElement.add(hexadecimalOprionElement);
    }
}