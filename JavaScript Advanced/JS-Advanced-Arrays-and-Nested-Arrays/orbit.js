function solve(arr) {
  let matrix = new Array(arr[0]).fill(0).map(() => new Array(arr[1]).fill(0));
  matrix[arr[2]][arr[3]] = 1;
  let n = 1;
  while (checkForZeros(matrix)) {
    for (let row = 0; row < matrix.length; row++) {
      for (let col = 0; col < matrix[row].length; col++) {
        const element = matrix[row][col];

        if (element === n) {
          if (validateCoordinates(row - 1, col) && matrix[row - 1][col] === 0) {
            matrix[row - 1][col] = n + 1;
          }
          if (validateCoordinates(row + 1, col) && matrix[row + 1][col] === 0) {
            matrix[row + 1][col] = n + 1;
          }
          if (validateCoordinates(row, col - 1) && matrix[row][col - 1] === 0) {
            matrix[row][col - 1] = n + 1;
          }
          if (validateCoordinates(row, col + 1) && matrix[row][col + 1] === 0) {
            matrix[row][col + 1] = n + 1;
          }
          if (
            validateCoordinates(row - 1, col - 1) &&
            matrix[row - 1][col - 1] === 0
          ) {
            matrix[row - 1][col - 1] = n + 1;
          }
          if (
            validateCoordinates(row + 1, col + 1) &&
            matrix[row + 1][col + 1] === 0
          ) {
            matrix[row + 1][col + 1] = n + 1;
          }
          if (
            validateCoordinates(row - 1, col + 1) &&
            matrix[row - 1][col + 1] === 0
          ) {
            matrix[row - 1][col + 1] = n + 1;
          }
          if (
            validateCoordinates(row + 1, col - 1) &&
            matrix[row + 1][col - 1] === 0
          ) {
            matrix[row + 1][col - 1] = n + 1;
          }
        }
      }
    }
    n++;
  }

  for (let row = 0; row < matrix.length; row++) {
    console.log(matrix[row].join(" "));
  }

  function validateCoordinates(row, col) {
    return (
      row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length
    );
  }

  function checkForZeros(matrix) {
    for (let row = 0; row < matrix.length; row++) {
      if (matrix[row].includes(0)) {
        return true;
      }
    }
    return false;
  }
}
//solve([4, 4, 0, 0]);
//solve([5, 5, 2, 2]);
solve([3, 3, 2, 2]);
