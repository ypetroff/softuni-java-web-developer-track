class CarDealership {

    constructor(name) {
        this.name = name;
        this.availableCars = [];
        this.soldCars = [];
        this.totalIncome  = 0;
    }

    addCar (model, horsepower, price, mileage) {
        if(model === '' || horsepower < 0 || price < 0 || mileage < 0) {
            throw new Error('Invalid input!');
        }

        const car = {
            model,
            horsepower,
            price,
            mileage
        }

        this.availableCars.push(car);

        return `New car added: ${car.model} - ${car.horsepower} HP - ${car.mileage.toFixed(2)} km - ${car.price.toFixed(2)}$`
    }

    sellCar (model, desiredMileage) {
        const currentCar = this.availableCars.find(x => x.model === model);

        if(currentCar === undefined) {
            throw new Error(`${model} was not found!`);
        }

        let soldPrice = this.findFinalPrice(currentCar.price, desiredMileage, currentCar.mileage);    
        
        const index = this.availableCars.findIndex((x) => x.model === model);
        this.availableCars.splice(index, 1);

        this.soldCars.push({
           model: currentCar.model,
           horsepower: currentCar.horsepower,
           soldPrice
        })

        this.totalIncome += soldPrice;
        
        return `${model} was sold for ${soldPrice.toFixed(2)}$`
    }

    currentCar () {
        if(this.availableCars.length === 0) {
            return "There are no available cars";
        }
        const fLine = '-Available cars:'
        const sLine = this.availableCars
        .map((x) => `---${x.model} - ${x.horsepower} HP - ${x.mileage.toFixed(2)} km - ${x.price.toFixed(2)}$`).join('\n');

        return [fLine, sLine].join('\n');
    }

    salesReport (criteria) {
        if(criteria !== 'horsepower' && criteria !== 'model') {
            throw new Error('Invalid criteria!');
        }
        let output = '';
        if(criteria === 'horsepower') {
            output = this.soldCars
            .sort((a, b) => b[criteria] - a[criteria])
            .map((x) => `---${x.model} - ${x.horsepower} HP - ${x.soldPrice.toFixed(2)}$`)
            .join('\n');
        } else if (criteria === 'model') {
            output = this.soldCars
            .sort((a, b) => a[criteria].localeCompare(b[criteria]))
            .map((x) => `---${x.model} - ${x.horsepower} HP - ${x.soldPrice.toFixed(2)}$`)
            .join('\n'); 
        }

        return [`-${this.name} has a total income of ${this.totalIncome.toFixed(2)}$`,
        `-${this.soldCars.length} cars sold:`,
        `${output}`].join('\n');
        
       
    }


    findFinalPrice(vehiclePrice, desiredMileage, vehicleMileage) {

        if(vehicleMileage <= desiredMileage) {
            return vehiclePrice;
        }

        const difference = vehicleMileage - desiredMileage;

        return difference <= 40000
        ? vehiclePrice - (vehiclePrice * .05)
        : vehiclePrice - (vehiclePrice * .1);

    }
}

let dealership = new CarDealership('SoftAuto');
// console.log(dealership.addCar('Toyota Corolla', 100, 3500, 190000));
// console.log(dealership.addCar('Mercedes C63', 300, 29000, 187000));
// console.log(dealership.addCar('', 120, 4900, 240000));

// dealership.addCar('Toyota Corolla', 100, 3500, 190000);
// dealership.addCar('Mercedes C63', 300, 29000, 187000);
// dealership.addCar('Audi A3', 120, 4900, 240000);
// console.log(dealership.sellCar('Toyota Corolla', 230000));
// console.log(dealership.sellCar('Mercedes C63', 110000));

// dealership.addCar('Toyota Corolla', 100, 3500, 190000);
// dealership.addCar('Mercedes C63', 300, 29000, 187000);
// dealership.addCar('Audi A3', 120, 4900, 240000);
// console.log(dealership.currentCar());

// dealership.addCar('Toyota Corolla', 100, 3500, 190000);
// dealership.addCar('Mercedes C63', 300, 29000, 187000);
// dealership.addCar('Audi A3', 120, 4900, 240000);
// dealership.sellCar('Toyota Corolla', 230000);
// dealership.sellCar('Mercedes C63', 110000);
// console.log(dealership.salesReport('horsepower'));


