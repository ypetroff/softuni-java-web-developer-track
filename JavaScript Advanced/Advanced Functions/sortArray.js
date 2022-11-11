function solve(array, command) {

    let map = {
        asc: (a, b) => a-b,
        desc: (a, b) => b-a
    }
return array.sort(map[command]);
    }
   
function solve2(array, command) {
    return command === 'asc' ? array.sort((a, b) => a-b) : array.sort((a,b) => b-a);
}

console.log( solve2([14, 7, 17, 6, 8], 'asc'));
console.log( solve2([14, 7, 17, 6, 8], 'desc'));

