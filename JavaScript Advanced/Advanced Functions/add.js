function solution(n) {
let result = n;

return function add(m) {
    return result + m;
}
}

//other solution
function solve(n) {
    function add(a, b) {
        return a+ b;
    }

    return add.bind(this, n)
}

let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));
