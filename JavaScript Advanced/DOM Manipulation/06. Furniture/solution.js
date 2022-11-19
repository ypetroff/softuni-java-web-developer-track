function solve() {
  const generateButtonElement = document.querySelector(
    "#exercise > button:nth-child(3)"
  );
  generateButtonElement.addEventListener("click", generate);

  const buyButtonElement = document.querySelector('#exercise > button:nth-child(6)');
  buyButtonElement.addEventListener('click', buyCheckedItems);

  function generate() {
    let input = JSON.parse(
      document.querySelector("#exercise > textarea:nth-child(2)").value
    );

    for (const obj of input) {
      const img = document.createElement("img");
      img.src = obj.img;
      const tdIMG = document.createElement("td");
      tdIMG.appendChild(img);

      const pName = document.createElement("p");
      pName.textContent = obj.name;
      const tdName = document.createElement("td");
      tdName.appendChild(pName);

      const pPrice = document.createElement("p");
      pPrice.textContent = obj.price;
      const tdPrice = document.createElement("td");
      tdPrice.appendChild(pPrice);

      const pDecFactor = document.createElement("p");
      pDecFactor.textContent = obj.decFactor;
      const tdDecFactor = document.createElement("td");
      tdDecFactor.appendChild(pDecFactor);

      const inputCheckbox = document.createElement("input");
      inputCheckbox.type = "checkbox"; //disabled?
      const tdCheckbox = document.createElement("td");
      tdCheckbox.appendChild(inputCheckbox);

      const tr = document.createElement("tr");
      tr.appendChild(tdIMG);
      tr.appendChild(tdName);
      tr.appendChild(tdPrice);
      tr.appendChild(tdDecFactor);
      tr.appendChild(tdCheckbox);

      document
        .querySelector("#exercise > div > div > div > div > table > tbody")
        .appendChild(tr);
    }
  }

  function buyCheckedItems() {
  
    const markedTableElements = document.querySelectorAll('#exercise > div > div > div > div > table > tbody input[type=checkbox]:checked');
    const outputArea = document.querySelector('#exercise > textarea:nth-child(5)');

    const items = getitemsNames(markedTableElements);
    outputArea.value += `Bought furniture: ${items.join(', ')}` + '\n';

    const totalPrices = getTotalPrice(markedTableElements)
    outputArea.value += `Total price: ${totalPrices.toFixed(2)}` + '\n';
  
    const averageDecFactor = getDecFactorAverage(markedTableElements);
    outputArea.value += `Average decoration factor: ${averageDecFactor}`
  }

 function getitemsNames(arrayOftr) {
  let names = [];
  arrayOftr.forEach(x => names.push(x.parentElement.parentElement.querySelector('td:nth-child(2) > p').textContent));
  return names;
 }

 function getTotalPrice(arrayOftr) {
  let prices = [];
  arrayOftr.forEach(x => prices.push(Number(x.parentElement.parentElement.querySelector('td:nth-child(3) > p').textContent)));
  return prices.reduce((acc, p) => acc + p, 0);
 }

 function getDecFactorAverage(arrayOftr) {
  let decFactor = [];
  arrayOftr.forEach(x => decFactor.push(Number(x.parentElement.parentElement.querySelector('td:nth-child(4) > p').textContent)));
  const sum = decFactor.reduce((acc, p) => acc + p, 0);
  return sum / decFactor.length;
 }
}
