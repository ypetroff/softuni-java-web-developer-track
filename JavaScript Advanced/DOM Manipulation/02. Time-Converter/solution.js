function attachEventsListeners() {
  Array.from(document
    .querySelectorAll('input[type="button"]'))
    .forEach((x) => x.addEventListener("click", convert));

  function convert(e) {
    let elemet = e.target.previousElementSibling;
    let unit = elemet.id;
    let quantity = elemet.value;
    let quantityAsDays = conversion(unit, quantity);

    fillFields(quantityAsDays);
  }

  function conversion(unit, quantity) {
    let output = 0;

    switch (unit) {
      case "days":
        output = quantity;
        break;
      case "hours":
        output = quantity / 24;
        break;
      case "minutes":
        output = quantity / 1440;
        break;
      case "seconds":
        output = quantity / 86400;
        break;
      default:
        console.log("No such unit");
    }
    return output;
  }

  function fillFields(days) {
    document.getElementById("days").value = days;
    document.getElementById("hours").value = days * 24;
    document.getElementById("minutes").value = days * 1440;
    document.getElementById("seconds").value = days * 86400;
  }
}
