function solve() {
  const infoElement = document.querySelector("#info > span");
  const departBtn = document.getElementById("depart");
  const arriveBtn = document.getElementById("arrive");

  let stop = {
    next: "depot",
  };

  async function depart() {
    departBtn.disabled = true;
    arriveBtn.disabled = false;

    const url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`;

    const result = await fetch(url);
    const data = await result.json();

    stop = {
        name: data.name,
        next: data.next
    }

    infoElement.textContent = `Next stop ${stop.name}`;
  }

  function arrive() {
    departBtn.disabled = false;
    arriveBtn.disabled = true;

    infoElement.textContent = `Arriving at ${stop.name}`;
  }

  return {
    depart,
    arrive,
  };
}

let result = solve();
