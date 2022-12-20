function solve(input) {
    let products = [];
    for (const townInfo of input) {
        let [name, product, price] = townInfo.split(' | ');
        price = Number(price);
        
        if(products.filter(t => t.product === product).length > 0) {
           
            let obj = products.find(x => x.product === product);

            if(obj.price > price) {
                obj.price = price;
                obj.name = name;
            }
           
        } else {
            let obj = {name, price, product}
            products.push(obj);
        }
    }

    products.forEach(x => console.log(`${x.product} -> ${x.price} (${x.name})`));

   
}
solve(['Sample Town | Sample Product | 1000',
'Sample Town | Orange | 2',
'Sample Town | Peach | 1',
'Sofia | Orange | 3',
'Sofia | Peach | 2',
'New York | Sample Product | 1000.1',
'New York | Burger | 10']
);
