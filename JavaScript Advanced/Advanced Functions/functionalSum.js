function add(a) {
    let sum = 0;
    function output(b) {
        sum += b;
        return output;
    }
    output.toString = () => {
        return sum;
    }

    return output(a);
}

console.log(add(1).toString());
console.log(add(1)(6)(-3).toString());