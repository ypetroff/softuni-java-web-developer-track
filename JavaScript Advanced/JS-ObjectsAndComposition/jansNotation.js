function solve(input) {
  let numbers = [];
  let arr = input.includes('error') ? input.slice(0, input.indexOf('error')) : input.slice();

  let numCounter = arr.filter(x => !isNaN(x)).length;

  for (const element of arr) {
    if (!isNaN(element)) {
      numbers.push(element);
    } else {
      if (numbers.length < 2) {
        console.log("Error: not enough operands!");
      } else {
        const num1 = numbers.pop();
        const num2 = numbers.pop();
        let result;
        switch (element) {
          case "+":
            result = num1 + num2;
            break;
          case "-":
            result = num2 - num1;
            break;
          case "*":
            result = num1 * num2;
            break;
          case "/":
            result = num2 / num1;
            break;
          default:
            console.log("Unsupported operation");
            break;
        }
        numbers.push(result);
      }
    }
  }

  if (numbers.length === 1 && numCounter !== 1) {
    console.log(numbers[0]);
  } else if(numCounter > 1) {
    console.log("Error: too many operands!");
  }
}

//solve([3, 4, "+"]);
//solve([5, 3, 4, "*", "-"]);
//solve([7, 33, 8, "-"]);
//solve([15, "/"]);
solve([5, 1, '/', 3, 'error', '+']);
