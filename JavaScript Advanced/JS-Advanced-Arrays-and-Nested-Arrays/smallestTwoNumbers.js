function smallestTwoNumbers(inputArr) {
let output = [];
if(inputArr.length === 0) {
    console.log();
}
inputArr.sort((a, b) => a - b);

let length = Math.min(2, inputArr.length);
for (let index = 0; index < length; index++) {
    output.push(inputArr[index]);  
}

console.log(output.join(' '));
}
smallestTwoNumbers([30, 15, 50, 5]);
smallestTwoNumbers([3, 0, 10, 4, 7, 3]);
smallestTwoNumbers([12, 14, 11]);
smallestTwoNumbers([191]);

/*
inputArr.sort((a, b) => a - b)
        .slice(0, 2)
        .join(' ');
*/