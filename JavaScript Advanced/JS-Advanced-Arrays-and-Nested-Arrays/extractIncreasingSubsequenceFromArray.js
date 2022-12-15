function solve(arr) {
  let biggestNumber = arr[0];
  let output = [biggestNumber];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] >= biggestNumber) {
      output.push(arr[i]);
      biggestNumber = arr[i];
    }
  }
  return output;
}
solve([1, 3, 8, 4, 10, 12, 3, 2, 24]);
solve([1, 2, 3, 4]);
solve([20, 3, 2, 15, 6, 1]);
