function negativeAndPositiveNumbers(inputArr) {
let outputArr = [];

for (let index = 0; index < inputArr.length; index++) {
    const element = inputArr[index];

    if(element < 0) {
        outputArr.unshift(element);
    } else {
        outputArr.push(element);
    }
}
outputArr.forEach(x => console.log(x));
}
negativeAndPositiveNumbers([7, -2, 8, 9])