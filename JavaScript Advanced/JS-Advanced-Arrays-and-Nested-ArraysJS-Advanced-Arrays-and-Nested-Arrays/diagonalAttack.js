function solve(input) {
  let arr = [];
  for (let i = 0; i < input.length; i++) {
    let temp = input[i].split(" ").map(Number);
    arr.push(temp);
  }

  let mainDiagonalSum = 0;
  let secondaryDiagonalSum = 0;

  for (let i = 0; i < arr.length; i++) {
    mainDiagonalSum += arr[i][i];
    secondaryDiagonalSum += arr[i][arr[i].length - 1 - i];
  }

  if (mainDiagonalSum === secondaryDiagonalSum) {
    for (let row = 0; row < arr.length; row++) {
      for (let col = 0; col < arr[row].length; col++) {
        if (row === col || col === arr[row].length - 1 - row) {
          continue;
        }
        arr[row][col] = mainDiagonalSum;
      }
    }
  }
  printMatrix(arr);

  function printMatrix(arr) {
    for (let row = 0; row < arr.length; row++) {
      console.log(arr[row].join(' '));
    }
  }
}
/*solve([
  "5 3 12 3 1",
  "11 4 23 2 5",
  "101 12 3 21 10",
  "1 4 5 2 2",
  "5 22 33 11 1",
]); */
solve(["1 1 1", "1 1 1", "1 1 0"]);
