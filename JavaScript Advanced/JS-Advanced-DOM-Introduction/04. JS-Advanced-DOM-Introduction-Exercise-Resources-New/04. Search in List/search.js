function search() {
   let unorderedListElements = Array.from(document.querySelectorAll('#towns li'));
  let searchForElement = document.getElementById('searchText').value;
  let resultElement = document.getElementById('result');
  let count = 0;
  
  for (const element of unorderedListElements) {
     if(element.textContent.includes(searchForElement) && searchForElement !== '') {
        element.style.fontWeight = 'bold';
        element.style.textDecoration = 'underline';
        count++;
     } else {
      element.style.fontWeight = 'normal';
      element.style.textDecoration = 'none';
     }
  }
  resultElement.textContent = `${count} matches found`
}
