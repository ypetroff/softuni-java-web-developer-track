function evenPosElements(input) {

    let outputAsString = [];

    for (let index = 0; index < input.length; index+=2) {
        const element = input[index];
        outputAsString.push(element);
    }

    console.log(outputAsString.join(' '));

}
evenPosElements(['20', '30', '40', '50', '60']);
evenPosElements(['5', '10']);

function findNumbersOnEvenPositions(numbers) {
    let numbersOnEvenPositions = numbers.filter((x, i) => i % 2 === 0);

   return numbersOnEvenPositions.join(' ');
}