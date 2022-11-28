window.addEventListener("load", solve);

function solve() {
  const makeElement = document.getElementById("make");
  const modelElement = document.getElementById("model");
  const yearElement = document.getElementById("year");
  const fuelElement = document.getElementById("fuel");
  const originalCostElement = document.getElementById("original-cost");
  const sellinPriceElement = document.getElementById("selling-price");
  const tableElement = document.getElementById("table-body");
  const soldCarsElement = document.getElementById("cars-list");
  const totalProfitElement = document.getElementById("profit");

  const publishButton = document.getElementById("publish");
  publishButton.addEventListener("click", moveToTable);

  let total = 0;

  function moveToTable(e) {
    e.preventDefault();

    const fields = {
      make: makeElement.value,
      model: modelElement.value,
      year: yearElement.value,
      fuel: fuelElement.value,
      cost: originalCostElement.value,
      price: sellinPriceElement.value,
    };

    if (
      fields.make === "" ||
      fields.model === "" ||
      fields.year === "" ||
      fields.fuel === "" ||
      fields.cost === "" ||
      fields.price === "" ||
      fields.cost > fields.price
    ) {
      return;
    }

    const tr = document.createElement("tr");
    tr.setAttribute("class", "row");

    for (let value of Object.values(fields)) {
      const td = document.createElement("td");
      td.textContent = value;
      tr.appendChild(td);
    }

    const editButton = document.createElement("button");
    editButton.setAttribute("class", "action-btn");
    editButton.classList.add("edit");
    editButton.textContent = "Edit";
    editButton.addEventListener("click", returnValues);

    function returnValues() {
      makeElement.value = fields.make;
      modelElement.value = fields.model;
      yearElement.value = fields.year;
      fuelElement.value = fields.fuel;
      originalCostElement.value = fields.cost;
      sellinPriceElement.value = fields.price;

      tr.remove();
    }

    tr.appendChild(editButton);

    const sellButton = document.createElement("button");
    sellButton.setAttribute("class", "action-btn");
    sellButton.classList.add("sell");
    sellButton.textContent = "Sell";
    sellButton.addEventListener("click", sellVehicle);

    function sellVehicle() {
      const li = document.createElement("li");
      li.setAttribute("class", "each-list");

      const span1 = document.createElement("span");
      span1.textContent = `${fields.make} ${fields.model}`;
      li.appendChild(span1);

      const span2 = document.createElement("span");
      span2.textContent = fields.year;
      li.appendChild(span2);
      const span3 = document.createElement("span");
      const difference = Number(fields.price) - Number(fields.cost);
      total += difference;
      span3.textContent = `${difference}`;
      li.appendChild(span3);

      soldCarsElement.appendChild(li);
      tr.remove();

      totalProfitElement.textContent = `${total.toFixed(2)}`;
    }
    tr.appendChild(sellButton);

    tableElement.appendChild(tr);

    makeElement.value = "";
    modelElement.value = "";
    yearElement.value = "";
    fuelElement.value = "";
    originalCostElement.value = "";
    sellinPriceElement.value = "";
  }
}
