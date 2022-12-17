function solve() {
  /**We take the input element && take its value, whch is the text itself.
   * Then split it to create an array of each sentence
   *then we remove all empty elements**/
  let inputTextElements = document
    .getElementById("input")
    .value.split(".")
    .filter((x) => x !== "");
// Take the output element
  let outputTextElement = document.getElementById("output");
//Splice to upto 3 sentences for each paragraph
  while (inputTextElements.length > 0) {
    let currentParagraph = inputTextElements.splice(0, 3).join(".") + "."; // 3 sentences => 3 array elements joined by '.' 
    let paragraph = document.createElement("p"); // create <p>
    paragraph.textContent = currentParagraph; // add content to the <p>
    outputTextElement.appendChild(paragraph); // add <p> to the output element
  }
}
