function cookingByNumbers(number, ...operations) {
  let currentStatus = Number(number);

  operations.forEach(operation);

  function operation(command) {
    switch (command) {
      case "chop":
          currentStatus /= 2;
        break;
      case "dice":
         currentStatus = Math.sqrt(currentStatus);
        break;
      case "spice":
          currentStatus++;
        break;
      case "bake":
          currentStatus *= 3;
        break;
      case "fillet":
          currentStatus *= .8;
          currentStatus = currentStatus.toFixed(1);
        break;
    }
    console.log(currentStatus);
  }
}

cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet')
