function solve(input) {
let arr = [];

let obj = {
    add: x => arr.push(x),
    remove: x => (arr = arr.filter(e => e !== x)),
    print: () => console.log(arr.join(','))
};

input.forEach(x => {
    let [command, value] = x.split(' ');

    obj[command](value);
});
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);