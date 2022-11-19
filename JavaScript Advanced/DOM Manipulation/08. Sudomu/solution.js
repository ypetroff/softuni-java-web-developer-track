function solve() {
  const clearBtnElement = document.querySelector(
    "#exercise > table > tfoot > tr > td > button:nth-child(2)"
  );
  const tableBodyElement = document.querySelector("#exercise > table > tbody");
  let table = tableBodyElement.parentElement;
  let rows = Array.from(tableBodyElement.children);
  const checkElement = document.querySelector("#check > p");

  clearBtnElement.addEventListener("click", clearContent);
  clearBtnElement.addEventListener("click", returnToDefault);

  const quickCheckBtnElement = document.querySelector(
    "#exercise > table > tfoot > tr > td > button:nth-child(1)"
  );

  quickCheckBtnElement.addEventListener("click", checkNumbers);

  function clearContent() {
    for (const row of rows) {
      cells = row.querySelectorAll("td");

      for (const cell of cells) {
        cell.querySelector("input[type=number]").value = "";
      }
    }
  }

  function returnToDefault() {
    checkElement.textContent = "";

    table.style.border = "none";
  }

  function checkNumbers() {
    const rowsAreCorrect = checkNumberArrangement("row");
    const columnsAreCorrect = checkNumberArrangement("col");

    table.style.border = "2px solid";

    if (rowsAreCorrect && columnsAreCorrect) {
      table.style.borderColor = "green";
      checkElement.style.color = "green";
      checkElement.textContent = "You solve it! Congratulations!";
    } else {
      table.style.borderColor = "red";
      checkElement.style.color = "red";
      checkElement.textContent = "NOP! You are not done yet...";
    }
  }

  function checkNumberArrangement(target) {
    const length = tableBodyElement.childElementCount;
    let firstLength = 0;
    let secondLength = 0;
    let first = 0;
    let second = 0;

    if (target === "row") {
      firstLength = length;
      second = 1;
      secondLength = length + 1;
    } else if (target === "col") {
      firstLength = length + 1;
      first = 1;
      secondLength = length;
    }

    for (first; first < firstLength; first++) {
      let map = new Map();
      for (second; second < secondLength; second++) {
        const cellValue =
          target === "row"
            ? rows[first].querySelector(
                `:nth-child(${second}) > input[type=number]`
              ).value
            : rows[second].querySelector(
                `:nth-child(${first}) > input[type=number]`
              ).value;

        if (map.has(cellValue)) {
          map.set(cellValue, map.get(cellValue) + 1);
        } else {
          map.set(cellValue, 1);
        }
      }
      if (Array.from(map.values()).some((x) => x > 1)) {
        return false;
      }
    }
    return true;
  }
}
