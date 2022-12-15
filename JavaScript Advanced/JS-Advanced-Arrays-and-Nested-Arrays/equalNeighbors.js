function equalNeighbors(array) {

    let numberOfEqualPairs = 0;

    for (let row = 0; row < array.length; row++) {
        for (let col = 0; col < array[row].length; col++) {
            let currentElement = array[row][col];

            if(row < array.length - 1) {
               neighbourCheck(currentElement, row + 1, col); 
            }
            
        
            if(col < array[row].length - 1) {
               neighbourCheck(currentElement, row, col + 1); 
            }
            
  
        }
        
    }

    console.log(numberOfEqualPairs);

    function neighbourCheck(currentElement, r, c) {

       let neighbour = array[r][c];

        if(currentElement == neighbour) {
            numberOfEqualPairs++;
        }
    }
}
equalNeighbors([
['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']
]);
equalNeighbors([
['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]
);
equalNeighbors([
    [2, 2, 5, 7, 4],
    [4, 0, 5, 3, 4],
    [2, 5, 5, 4, 2]
    ]);