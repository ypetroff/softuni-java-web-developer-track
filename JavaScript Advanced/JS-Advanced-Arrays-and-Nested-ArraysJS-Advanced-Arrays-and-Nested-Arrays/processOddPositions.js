function processOddPositions(inputArr) {
 let arr = [];
 for (let index = 1; index < inputArr.length; index+=2) {
     const element = inputArr[index];
     arr.push(element);
     
 }

return arr
.map(x => x * 2)
.reverse(); 

/*
 return numbers
        .filter((x, i) => i % 2 != 0)
        .map(x => x * 2)
        .reverse()
        .join(' ');
*/
}
processOddPositions([10, 15, 20, 25]);
processOddPositions([3, 0, 10, 4, 7, 3]);
processOddPositions([0, 3, 6, 7, 3, 3]);