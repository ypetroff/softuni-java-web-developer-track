function attachGradientEvents() {
  let gradientElement = document.getElementById("gradient")
  .addEventListener("mousemove", percentage);

  let resultElement = document.getElementById("result");

  function percentage(event) {
    resultElement.textContent = `${Math.floor(event.offsetX / event.target.clientWidth * 100)}%`; //returtns -1?
  }
}
