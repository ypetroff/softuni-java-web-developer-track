function attachEventsListeners() {
  const convertBtnElement = document.querySelector("#convert");

  convertBtnElement.addEventListener("click", converter);

  function converter() {
    const inputNumber = Number(document.querySelector("#inputDistance").value);
    const inputUnit = document.querySelector("#inputUnits").value;

    const NumberInMeters = convertNumber(inputNumber, inputUnit, "*");

    const outputUnit = document.querySelector("#outputUnits").value;
    const oututNumber = convertNumber(NumberInMeters, outputUnit, "/");

    document.querySelector("#outputDistance").value = oututNumber;
  }

  function convertNumber(number, unit, operator) {
    let output = 0;
    switch (unit) {
      case "km":
        output = mathOperation(number, operator, 1000);
        break;
      case "m":
        output = number;
        break;
      case "cm":
        output = mathOperation(number, operator, 0.01);
        break;
      case "mm":
        output = mathOperation(number, operator, 0.001);
        break;
      case "mi":
        output = mathOperation(number, operator, 1609.34);
        break;
      case "yrd":
        output = mathOperation(number, operator, 0.9144);
        break;
      case "ft":
        output = mathOperation(number, operator, 0.3048);
        break;
      case "in":
        output = mathOperation(number, operator, 0.0254);
        break;

      default:
        console.log("Error");
        break;
    }

    return output;
  }

  function mathOperation(x, operator, y) {
    if (operator === "*") {
      return x * y;
    } else if (operator === "/") {
      return x / y;
    }
  }
}
