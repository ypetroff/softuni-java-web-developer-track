const {assert} = require('chai');
const { rentCar } = require('./rentCar');

describe('RentCar Tests', () => {
    describe('searchCar Tests', () => {
        const cars = ['a'];
        it('Should find all cars from the requested model in the provided array', () => {
            assert.equal(rentCar.searchCar(cars, 'a'), 'There is 1 car of model a in the catalog!');
            cars.push('b');
            assert.equal(rentCar.searchCar(cars, 'a'), 'There is 1 car of model a in the catalog!');
            cars.push('a');
            assert.equal(rentCar.searchCar(cars, 'a'), 'There is 2 car of model a in the catalog!');
    
        });
        it('Should throw error no such model', () => {
            assert.throws(() => (rentCar.searchCar(cars, 'c')), 'There are no such models in the catalog!');
        });
        it('Should throw error when invalid input', () => {
            assert.throws(() => (rentCar.searchCar('cars', 'c')), 'Invalid input!');   
            assert.throws(() => (rentCar.searchCar('cars', [])), 'Invalid input!'); 
            assert.throws(() => (rentCar.searchCar({}, '[]')), 'Invalid input!');
            assert.throws(() => (rentCar.searchCar(() => {}, '[]')), 'Invalid input!');
            assert.throws(() => (rentCar.searchCar(1, '[]')), 'Invalid input!');
            assert.throws(() => (rentCar.searchCar(cars, {})), 'Invalid input!');
            assert.throws(() => (rentCar.searchCar(cars, 1)), 'Invalid input!');
            assert.throws(() => (rentCar.searchCar(cars, () => {})), 'Invalid input!');
        });
    });
    describe('calculatePriceOfCar Tests', () => {
        it('Should choose a model part of the catalogue with correct price', () => {
            assert.equal(rentCar.calculatePriceOfCar('BMW', 1), 'You choose BMW and it will cost $45!');
            assert.equal(rentCar.calculatePriceOfCar('BMW', 2), 'You choose BMW and it will cost $90!');
        });
        it('Should throw error no such model', () => {
            assert.throws(() => rentCar.calculatePriceOfCar('Ford', 1), 'No such model in the catalog!');
        });
        it('Should throw error invalid input', () => {
            assert.throws(() => rentCar.calculatePriceOfCar('Ford', 'Ford'), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar('Ford', []), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar('Ford', {}), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar('Ford', 1.1), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar([], 1), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar(1, 1), 'Invalid input!');
            assert.throws(() => rentCar.calculatePriceOfCar({}, 1), 'Invalid input!');
          
        });
    });
    describe('checkBudget Tests', () => {
        it('Should rent a car', () => {
            assert.equal(rentCar.checkBudget(1, 1, 2), 'You rent a car!');
            assert.equal(rentCar.checkBudget(2, 1, 2), 'You rent a car!');
            assert.equal(rentCar.checkBudget(1, 2, 2), 'You rent a car!');
        });
        it('Should return yo need a bigger budget', () => {
            assert.equal(rentCar.checkBudget(2, 1, 1), 'You need a bigger budget!');
            assert.equal(rentCar.checkBudget(1, 2, 1), 'You need a bigger budget!');
        });
        it('Should throw error invalid input', () => {
            assert.throws(() => rentCar.checkBudget(1, 1, 1.1), 'Invalid input!');
            assert.throws(() => rentCar.checkBudget(1, 1.1, 1), 'Invalid input!');
            assert.throws(() => rentCar.checkBudget(1.1, 1, 1), 'Invalid input!');
        });
    });
});