function generateReport() {
 
  let columnHeadingElements = document.querySelectorAll("thead > tr > th > input");
  let tableElements = document.querySelectorAll("tbody > tr");
  let objects = [];

for (const row of tableElements) {
    let obj = {};
    for (let i = 0; i < row.children.length; i++) {
      
        if (columnHeadingElements[i].checked) { /// check if the input field is checked or not.
 
            obj[columnHeadingElements[i].name] = row.children[i].textContent;
          }  
      }
     
      objects.push(obj);
    } 
 document.getElementById('output').textContent = JSON.stringify(objects);
}