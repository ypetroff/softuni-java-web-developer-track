function squareOfStars(parameter) {
  let dimensions = 5;

  if (parameter !== undefined) {
    dimensions = parameter;
  }

  let square = "";
  for (let index = 0; index < dimensions; index++) {
    for (let i = 0; i < dimensions; i++) {
      square += "* ";
    }
    square += "\n";
  }
  console.log(square);
}
squareOfStars(8);
squareOfStars();
