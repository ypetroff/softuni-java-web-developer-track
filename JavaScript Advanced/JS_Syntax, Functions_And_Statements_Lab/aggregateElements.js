function aggregateElements(elements) {
    let arr = elements.map(Number);
    let sum = arr.reduce((a, b) => a + b);
    console.log(sum);

    let inverseSum = 0;
       
        for (let index = 0; index < arr.length; index++) {
            inverseSum+= 1 / arr[index];
        }
       
    console.log(inverseSum);

    let concatValues = arr.join('');
    console.log(concatValues);
}
aggregateElements([2, 4, 8, 16]);