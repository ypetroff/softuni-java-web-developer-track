function solve() {
    const args = Array.from(arguments);
    let result = {};
    args.forEach(arg => {
        console.log(`${typeof(arg)}: ${arg}`);
        if(result[typeof(arg)] === undefined) {
            result[typeof(arg)] = 0;
        }
        result[typeof(arg)]++;
    });
     Object.entries(result).sort((a, b) => b[1] - a[1]).forEach(e => console.log(`${e[0]} = ${e[1]}`));
}
solve('cat', 42, function () { console.log('Hello world!'); }, 'dog', 33, 22);