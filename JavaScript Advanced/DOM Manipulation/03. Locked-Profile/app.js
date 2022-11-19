function lockedProfile() {
  let showMoreButtons = document.querySelectorAll("button");
  Array.from(showMoreButtons).forEach((x) => x.addEventListener("click", showInfo));

  function showInfo(e) {
    const parentElement = e.target.parentElement;
    let hiddenInformation = parentElement.querySelector(`[id$='HiddenFields']`);
    let currentButton = parentElement.querySelector("button");

    const lockCheckElement = parentElement.querySelector('input[value="lock"]');

    if (!lockCheckElement.checked) {
      if (currentButton.textContent === "Show more") {
        hiddenInformation.style.display = "block";
        currentButton.textContent = "Hide it";
      } else if (currentButton.textContent === "Hide it") {
        hiddenInformation.style.display = "none";
        currentButton.textContent = "Show more";
      }
    }
  }
}
