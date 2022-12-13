function sumOfNumbers(startNumber, endNumber) {
    let start = Number(startNumber);
    let end = Number(endNumber);
let result = 0;

for (let index = start; index <= end; index++) {
    result+=index;
}

console.log(result);
}

sumOfNumbers('1', '5');
sumOfNumbers('-8', '20');