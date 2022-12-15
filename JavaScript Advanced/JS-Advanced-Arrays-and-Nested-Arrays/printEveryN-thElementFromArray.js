function solve(array, increment) {
  let output = [];

  for (let i = 0; i < array.length; i += increment) {
    output.push(array[i]);
  }

  return output;

  //  return arrayOfStrings.filter((value, index) => index % n === 0);
}
solve(["5", "20", "31", "4", "20"], 2);
solve(["dsa", "asd", "test", "tset"], 2);
solve(["1", "2", "3", "4", "5"], 6);
