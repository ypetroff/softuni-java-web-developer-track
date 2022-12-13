function mathOperations(num1, num2, operator) {

/* DO NOT USE eval
let result = eval(num1+operation+num2);
*/
let result;
switch (operator){

    case '+': result = num1 + num2; break;
    case '-': result = num1 - num2; break;
    case '*': result = num1 * num2; break;
    case '/': result = num1 / num2; break;
    case '%': result = num1 % num2; break;
    case '**': result = num1 ** num2; break;

}
console.log(result);
}

mathOperations(5, 6, '+');
mathOperations(3, 5.5, '*');
mathOperations(2, 2, '**');
mathOperations('zoro', 33, '+');