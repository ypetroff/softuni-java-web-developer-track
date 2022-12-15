function diagonalSums(matrix) {

    let primaryDiagonal = 0;
    let secondaryDiagonal = 0;

    for (let index = 0; index < matrix.length; index++) {
        primaryDiagonal += matrix[index][index];
        secondaryDiagonal += matrix[index][matrix.length - index - 1];     
    }

        console.log(`${primaryDiagonal} ${secondaryDiagonal}`);
    }
diagonalSums([[20, 40],
    [10, 60]]
   );
diagonalSums([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   );