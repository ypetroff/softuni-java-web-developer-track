function focused() {
  Array.from(document.querySelectorAll('input')).forEach(x => {
      x.addEventListener('focus', focused);
      x.addEventListener('blur', blured);
  });
 
  function focused(event) {
event.target.parentNode.classList.add('focused');
  }

  function blured(event) {
      event.target.parentNode.classList.remove('focused');
  }
}