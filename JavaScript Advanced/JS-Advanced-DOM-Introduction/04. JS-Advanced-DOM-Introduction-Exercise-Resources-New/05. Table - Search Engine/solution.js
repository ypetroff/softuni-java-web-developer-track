function solve() {
  document.querySelector("#searchBtn").addEventListener("click", onClick);
  let tableDataElements = document.querySelectorAll("tbody tr");
  let textInputElement = document.getElementById("searchField");
  function onClick() {
     for (const row of tableDataElements) {
        row.classList.remove('select');
        if(textInputElement.value !== '' && row.innerHTML.includes(textInputElement.value)) {
           row.className = 'select'
        }
     }
     textInputElement.value = '';
  }
}
