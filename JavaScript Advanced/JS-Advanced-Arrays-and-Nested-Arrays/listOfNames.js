function solve(arr) {
   let counter = 1;
arr.sort((a, b) => a.localeCompare(b))
.forEach(x => {
    console.log(`${counter}.${x}`);
    counter++;
});
}
solve(["John", "Bob", "Christina", "Ema"]);