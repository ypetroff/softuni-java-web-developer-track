function solve(array) {
  let obj = {};
  for (let i = 0; i < array.length; i++) {

    obj[array[i]] = Number(array[++i]);
  }

  console.log(obj);
}
solve(["Yoghurt", "48", "Rise", "138", "Apple", "52"]);
