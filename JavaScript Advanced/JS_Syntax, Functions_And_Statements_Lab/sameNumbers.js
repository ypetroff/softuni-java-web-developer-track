function sameNumbers(input) {

    const arr = Array.from(String(input), Number);
    const firstDigit = arr[0];
    let allNumbersAreTheSame =  new Boolean(true);
    let sumOfAllNumbers = arr.reduce((a, b) => a +b);

    for (let index = 1; index < arr.length; index++) {
       if(firstDigit !== arr[index]) {
           allNumbersAreTheSame = false;
           break;
       }
        
    }

    console.log(allNumbersAreTheSame.toString());
    console.log(sumOfAllNumbers);

}
sameNumbers(2222222);
sameNumbers(1234)
sameNumbers(2232);