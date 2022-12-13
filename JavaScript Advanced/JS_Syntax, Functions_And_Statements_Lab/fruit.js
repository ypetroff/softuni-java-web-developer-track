function fruits(fruit, weight, price)   {

    let weightInKgs = weight / 1000;
    let amountToPay = weightInKgs * price;

    console.log(`I need $${amountToPay.toFixed(2)} to buy ${weightInKgs.toFixed(2)} kilograms ${fruit}.`);
}
fruits('orange', 2500, 1.80);
fruits('apple', 1563, 2.35);