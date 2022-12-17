function solve() {
  const inputString = document.getElementById("text").value.toLowerCase().split(" ");
  const namingConvention = document.getElementById("naming-convention").value;
  let result = "";

  if (namingConvention === "Pascal Case") {

    result = capitalizeFirstLetter(inputString);

  } else if (namingConvention === "Camel Case") {

    result = inputString[0];
    result += capitalizeFirstLetter(inputString.slice(1));

  } else {

    result = "Error!";
  }

  return document.getElementById("result").textContent = result;

  function capitalizeFirstLetter(array) {
    let output = [];
    array.forEach((x) => {
      output.push(x[0].toUpperCase() + x.slice(1));
    });
    return output.join("");
  }
}
