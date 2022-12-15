function solve(matrix) {

  let expectedSum = matrix[0].reduce((a, b) => a + b);
  let currentSum = 0;

  for (let row = 1; row < matrix.length; row++) {
    currentSum = matrix[row].reduce((a, b) => a + b);

    if (expectedSum !== currentSum) {
     return false;
    }
    currentSum = 0;
  }

  for (let col = 0; col < matrix[0].length; col++) {
      for (let row = 0; row < matrix.length; row++) {
         currentSum += matrix[row][col]; 
      }
      if (expectedSum !== currentSum) {
        return false;
       }
       currentSum = 0;
  }
  return true;
}
solve([
  [4, 5, 6],
  [6, 5, 4],
  [5, 5, 5],
]);
solve([
  [5, 6, 7],
  [7, 6, 5],
  [5, 6, 7],
]);
