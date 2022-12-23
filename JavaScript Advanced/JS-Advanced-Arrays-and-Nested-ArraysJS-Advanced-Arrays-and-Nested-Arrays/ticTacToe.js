function solve(input) {
  let field = [];

  for (let i = 0; i < 3; i++) {
    field.push([false, false, false]);
  }

  let gameOver = false;
  let index = 0;
  let mark = "X";
  while (!fieldIsFull()) {
    let coordinates = input[index].split(" ");
    let row = Number(coordinates[0]);
    let col = Number(coordinates[1]);

    if (cellIsOccupied(row, col)) {
      index++;
      continue;
    }

    field[row][col] = mark;

    if (rowCheck(row)) {
      gameOver = true;
      break;
    }

    if (columnCheck(col)) {
      gameOver = true;
      break;
    }

    if (diagonalsCheck()) {
      gameOver = true;
      break;
    }

    mark = mark === "X" ? "O" : "X";
    index++;
  }

  if (!gameOver) {
    console.log("The game ended! Nobody wins :(");
  } else {
    console.log(`Player ${mark} wins!`);
  }

  printMatrix();

  function printMatrix() {
    for (let row = 0; row < field.length; row++) {
      console.log(field[row].join("\t"));
    }
  }

  function diagonalsCheck() {
    let primCounter = 0;
    let secCounter = 0;
    const length = field.length;
    for (let i = 0; i < length; i++) {
      const primaryDiagonal = field[i][i];
      const secondaryDiagonal = field[i][length - 1 - i];

      if (primaryDiagonal !== mark) {
        primCounter++;
      }

      if (secondaryDiagonal !== mark) {
        secCounter++;
      }
    }

    if (primCounter === 0 || secCounter === 0) {
      return true;
    }
    return false;
  }

  function columnCheck(col) {
    for (let row = 0; row < field.length; row++) {
      if (field[row][col] !== mark) {
        return false;
      }
    }
    return true;
  }

  function rowCheck(row) {
    return field[row].every((val, i, arr) => val === arr[0]);
  }

  function cellIsOccupied(row, col) {
    if (field[row][col] !== false) {
      console.log("This place is already taken. Please choose another!");
      return true;
    }
    return false;
  }

  function fieldIsFull() {
    for (let row = 0; row < field.length; row++) {
      if (field[row].includes(false)) {
        return false;
      }
    }
    return true;
  }
}

//solve(["0 1", "0 0", "0 2", "2 0", "1 0", "1 1", "1 2", "2 2", "2 1", "0 0"]);
//solve(["0 0", "0 0", "1 1", "0 1", "1 2", "0 2", "2 2", "1 2", "2 2", "2 1"]);
//solve(["0 1", "0 0", "0 2", "2 0", "1 0", "1 2", "1 1", "2 1", "2 2", "0 0"]);
