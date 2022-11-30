class VegetableStore {

    constructor(owner, location) {
        this.owner = owner;
        this.location = location;
        this.availableProducts = [];
    }

    loadingVegetables (vegetables) {
        let output = new Set();
        vegetables.forEach((x) => {
            const [type, quantity, price] = x.split(' ');
            output.add(type);
            const vegie = {
                type,
                quantity: Number(quantity),
                price: Number(price)
            };
            const index = this.availableProducts.findIndex((x) => x.type === type);
            if(index === -1) {
                this.availableProducts.push(vegie);
            }else {
                this.availableProducts[index].quantity+=Number(quantity);
                const oldPrice = this.availableProducts[index].price;
                this.availableProducts[index].price = Number(oldPrice) < Number(price)
                ? Number(price)
                : Number(oldPrice);

            }
        });

        return `Successfully added ${[...output].join(', ')}`; // or array from
    }

    buyingVegetables (selectedProducts) {
        let totalPrice = 0;
        selectedProducts.forEach((x) => {
            const [type, quantity] = x.split(' ');
            const index = this.availableProducts.findIndex((x) => x.type === type);

            if(index === -1) {
                throw new Error (`${type} is not available in the store, your current bill is $${totalPrice.toFixed(2)}.`);
            }

            const currentProduct = this.availableProducts[index];

            if(Number(quantity) > Number(currentProduct.quantity)) {
                throw new Error (`The quantity ${quantity} for the vegetable ${type} is not available in the store, your current bill is $${totalPrice.toFixed(2)}.`);
            }

            totalPrice += Number(quantity) * Number(currentProduct.price);
            currentProduct.quantity -= Number(quantity);

        });

        return `Great choice! You must pay the following amount $${totalPrice.toFixed(2)}.`;
    }

    rottingVegetable (type, quantity) {
        const index = this.availableProducts.findIndex((x) => x.type === type);
         if( index === -1) {
            throw new Error (`${type} is not available in the store.`)
         }

        const currentProduct = this.availableProducts[index];
        //if quantity becomes exactly zero according to the instructions the code should not print the message in the if bellow
         if(Number(quantity) > Number(currentProduct.quantity)) {
            currentProduct.quantity = 0;

            return `The entire quantity of the ${type} has been removed.`
         }

         currentProduct.quantity -= Number(quantity);

         return `Some quantity of the ${type} has been removed.`
    }  
    
    revision () {
        let result = [];

        const line1 = "Available vegetables:";
        result.push(line1);

        const line2 = this.availableProducts
        .sort((a, b) => Number(a.price) - Number(b.price))
        .map((x) => `${x.type}-${x.quantity}-$${x.price}`)
        .join('\n');
        result.push(line2);

        const line3 = `The owner of the store is ${this.owner}, and the location is ${this.location}.`
        result.push(line3);
        
        return result.join('\n');
    }
} 

let vegStore = new VegetableStore("Jerrie Munro", "1463 Pette Kyosheta, Sofia");
console.log(vegStore.loadingVegetables(["Okra 2.5 3.5", "Beans 10 2.8", "Celery 5.5 2.2", "Celery 0.5 2.5"]));
console.log(vegStore.rottingVegetable("Okra", 1));
console.log(vegStore.rottingVegetable("Okra", 2.5));
console.log(vegStore.buyingVegetables(["Beans 8", "Celery 1.5"]));
console.log(vegStore.revision());

