function sumTable() {
let arr = Array.from(document.querySelectorAll('table tbody tr')).slice(1, -1);
let sum = arr.reduce((accumulator, num) => accumulator + Number(num.lastChild.textContent), 0); //0 -> initialValue
document.getElementById('sum').textContent = sum;
}