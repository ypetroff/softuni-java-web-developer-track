function solve(input) {
    let products = [];
    input.forEach(x => {
        let[item, price] = x.split(' : ');
        price = Number(price);
        const product = {item, price};
        products.push(product);
    });

    products.sort((a, b) => a.item.localeCompare(b.item))
    let letter = products[0].item.charAt(0);
    console.log(letter);
    products.forEach(x => {
        if(x.item.charAt(0) !== letter) {
            letter = x.item.charAt(0);
            console.log(letter);
        }
        console.log(`${x.item}: ${x.price}`);
    })
}
solve([
  "Appricot : 20.4",
  "Fridge : 1500",
  "TV : 1499",
  "Deodorant : 10",
  "Boiler : 300",
  "Apple : 1.25",
  "Anti-Bug Spray : 15",
  "T-Shirt : 10",
]);

/*
function foo(arr) {
    const result = arr.sort().reduce((a, v) => {
        a[v[0]] = a[v[0]] || []
        a[v[0]].push(v)
        return a
    }, {})
    Object.entries(result).forEach(([letter, items]) =>
        console.log(`${letter}
  ${items.map(y => y.split(" : ").join(": ")).join("\n  ")}`)
    )
}
*/ 
