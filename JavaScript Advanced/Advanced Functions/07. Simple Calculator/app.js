function calculator() {
    let element1;
    let element2;
    let result;

    return {
       init: (selector1, selector2, resultSelector) => {
        element1 = document.querySelector(selector1);
        element2 = document.querySelector(selector2);
        result = document.querySelector(resultSelector);
       },
        add: () => {
            result.value = +element1.value + +element2.value;
        },
        subtract: () => {
            result.value = +element1.value - +element2.value;
        },
    }
 
}

const calculate = calculator (); 
calculate.init ('#num1', '#num2', '#result'); 

console.log(calculate.add);
console.log(calculate.subtract);





