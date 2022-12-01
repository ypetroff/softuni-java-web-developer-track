class Garden {

    constructor(spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
        this.plants = [];
        this.storage = [];
    }

    findPlant(plantName) {
        return this.plants
            .find(x => x.plantName === plantName);
    }

    plantIsPresent(plantName, currentPlant) {
        if (currentPlant === undefined) {
            throw new Error(`There is no ${plantName} in the garden.`);
        }
    }

    arrangePlants() {
        return this.plants
            .sort((a, b) =>  
            a.plantName.localeCompare(b.plantName))
            .map((x) => x.plantName)
            .join(', ');
    }

    checkStorage() {
        return this.storage.length > 0
            ? this.storage.map(x => `${x.plantName} (${x.quantity})`).join(', ')
            : 'The storage is empty.'
    }

    addPlant(plantName, spaceRequired) {
        if (this.spaceAvailable < spaceRequired) {
            throw new Error("Not enough space in the garden.");
        }

        const newPlant = {
            plantName,
            spaceRequired,
            ripe: false,
            quantity: 0
        }

        this.plants.push(newPlant);
        this.spaceAvailable -= spaceRequired;
        return `The ${plantName} has been successfully planted in the garden.`
    }

    ripenPlant(plantName, quantity) {
        const currentPlant = this.findPlant(plantName); //without this?

        this.plantIsPresent(plantName, currentPlant); //without this?

        if (currentPlant.ripe) {
            throw new Error(`The ${plantName} is already ripe.`);
        }

        if (quantity <= 0) {
            throw new Error('The quantity cannot be zero or negative.');
        }

        currentPlant.ripe = true;
        currentPlant.quantity = quantity;

        const pluralOrSingular = quantity > 1 ? 's have' : ' has';

        return `${quantity} ${plantName}${pluralOrSingular} successfully ripened.`
    }

    harvestPlant(plantName) {

        const currentPlant = this.plants
        .find(x => x.plantName === plantName);

        this.plantIsPresent(plantName, currentPlant)

        if (!currentPlant.ripe) {
            throw new Error(`The ${plantName} cannot be harvested before it is ripe.`)
        }

        this.storage.push(currentPlant);
        const index = this.plants.findIndex(x => x.plantName === plantName);
        this.spaceAvailable += currentPlant.spaceRequired;
        this.plants.splice(index, 1);

        return `The ${plantName} has been successfully harvested.`;

    }

    generateReport() {

        const firstLine = `The garden has ${this.spaceAvailable} free space left.`;
        const secondLine = `Plants in the garden: ${this.arrangePlants()}`;
        const thirdLine = `Plants in storage: ${this.checkStorage()}`;

        let output = [];
        output.push(firstLine);
        output.push(secondLine);
        output.push(thirdLine);

        return output.join('\n');
    }

   
}

const myGarden = new Garden(250)
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 200));
// console.log(myGarden.addPlant('olive', 50));
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 100));
// console.log(myGarden.addPlant('cucumber', 30));
// console.log(myGarden.ripenPlant('apple', 10));
// console.log(myGarden.ripenPlant('orange', 1));
// console.log(myGarden.ripenPlant('orange', 4));
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 100));
// console.log(myGarden.addPlant('cucumber', 30));
// console.log(myGarden.ripenPlant('apple', 10));
// console.log(myGarden.ripenPlant('orange', 1));
// console.log(myGarden.ripenPlant('olive', 30));
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 100));
// console.log(myGarden.addPlant('cucumber', 30));
// console.log(myGarden.ripenPlant('apple', 10));
// console.log(myGarden.ripenPlant('orange', 1));
// console.log(myGarden.ripenPlant('cucumber', -5));
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 200));
// console.log(myGarden.addPlant('raspberry', 10));
// console.log(myGarden.ripenPlant('apple', 10));
// console.log(myGarden.ripenPlant('orange', 1));
// console.log(myGarden.harvestPlant('apple'));
// console.log(myGarden.harvestPlant('olive'));
// console.log(myGarden.addPlant('apple', 20));
// console.log(myGarden.addPlant('orange', 200));
// console.log(myGarden.addPlant('raspberry', 10));
// console.log(myGarden.ripenPlant('apple', 10));
// console.log(myGarden.ripenPlant('orange', 1));
// console.log(myGarden.harvestPlant('apple'));
// console.log(myGarden.harvestPlant('raspberry'));
console.log(myGarden.addPlant('apple', 20));
console.log(myGarden.addPlant('orange', 200));
console.log(myGarden.addPlant('raspberry', 10));
console.log(myGarden.ripenPlant('apple', 10));
console.log(myGarden.ripenPlant('orange', 1));
console.log(myGarden.harvestPlant('orange'));
console.log(myGarden.generateReport());







