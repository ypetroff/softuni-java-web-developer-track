function solution() {
  const ingredients = {
    protein: 0,
    carbohydrate: 0,
    fat: 0,
    flavour: 0,
  };

  const orders = {
    apple: recepieIngredients(0, 1, 0, 2),
    lemonade: recepieIngredients(0, 10, 0, 20),
    burger: recepieIngredients(0, 5, 7, 3),
    eggs: recepieIngredients(5, 0, 1, 1),
    turkey: recepieIngredients(10, 10, 10, 10),
  };

  function recepieIngredients(protein, carbohydrate, fat, flavour) {
    return {
      protein,
      carbohydrate,
      fat,
      flavour,
    };
  }

  function restock(ingredient, quantity) {
    ingredients[ingredient] += quantity;
    return "Success";
  }

  function prepare(recepie, quantity) {
    const cook = Object.entries(recepie).map((x) => [x[0], x[1] * quantity]);

    for (const [ingredient, quantity] of cook) {
      if (ingredients[ingredient] < quantity) {
        return `Error: not enough ${ingredient} in stock`;
      }
    }

    for (const [ingredient, quantity] of cook) {
      ingredients[ingredient] -= quantity;
    }
    return "Success";
  }

  const report = () =>
    Object.entries(ingredients)
      .map((x) => `${x[0]}=${x[1]}`)
      .join(" ");

  const commands = {
    restock,
    prepare: (recepie, quantity) => prepare(orders[recepie], quantity),
    report,
  };

  return str => {
    const [command, a, b] = str
    .split(" ")
    .map((x) => (isNaN(x) ? x : Number(x)));

    return commands[command](a, b);
  };
}

let manager = solution();
console.log(manager("restock flavour 50")); // Success
console.log(manager("prepare lemonade 4")); // Error: not enough carbohydrate in stock#
console.log(manager('restock carbohydrate 10'));
console.log(manager('restock flavour 10'));
console.log(manager('prepare apple 1'));
console.log(manager('restock fat 10'));
console.log(manager('prepare burger 1'));
console.log(manager('report'));

