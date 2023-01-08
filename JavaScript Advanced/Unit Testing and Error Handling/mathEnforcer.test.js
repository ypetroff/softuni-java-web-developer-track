const {assert} = require('chai');
const {mathEnforcer} = require('./mathEnforcer');

describe('mathEnforcer', () => {
    it('should have a function addFive', () => {
        assert.isFunction(mathEnforcer.addFive);
    });
    it('should have a function subtractTen', () => {
        assert.isFunction(mathEnforcer.subtractTen);
    });
    it('should have a function sum', () => {
        assert.isFunction(mathEnforcer.sum);
    });

    describe('addFive', () => {
        it('should return undefined if the parameter is not a number', () => {
            assert.isUndefined(mathEnforcer.addFive('pesho'));
        });
        it('should return undefined if the parameter is an array', () => {
            assert.isUndefined(mathEnforcer.addFive([1, 2, 3]));
        });
        it('should add 5 to a positive number', () => {
            assert.equal(mathEnforcer.addFive(5), 10);
        });
        it('should add 5 to a negative number', () => {
            assert.equal(mathEnforcer.addFive(-5), 0);
        });
        it('should add 5 to a floating point number', () => {
            assert.equal(mathEnforcer.addFive(5.5), 10.5);
        });
    });
    describe('subtractTen', () => {
        it('should return undefined if the parameter is not a number', () => {
            assert.isUndefined(mathEnforcer.subtractTen('pesho'));
        });
        it('should return undefined if the parameter is an array', () => {
            assert.isUndefined(mathEnforcer.subtractTen([1, 2, 3]));
        });
        it('should subtract 10 from a number', () => {
            assert.equal(mathEnforcer.subtractTen(5), -5);
        });
        it('should subtract 10 from a negative number', () => {
            assert.equal(mathEnforcer.subtractTen(-5), -15);
        });
        it('should subtract 10 from a floating point number', () => {
            assert.equal(mathEnforcer.subtractTen(5.5), -4.5);
        });
    });
    describe('sum', () => {
        it('should return undefined if the parameters are not numbers', () => {
            assert.isUndefined(mathEnforcer.sum('pesho', 'gosho'));
        });
        it('should return undefined if the first parameter is not a number', () => {
            assert.isUndefined(mathEnforcer.sum('pesho', 3));
        });
        it('should return undefined if the second parameters is not a number', () => {
            assert.isUndefined(mathEnforcer.sum(3, 'gosho'));
        });
        it('should return the sum of two positive numbers', () => {
            assert.equal(mathEnforcer.sum(3, 4), 7);
        });
        it('should return the sum of two negative numbers', () => {
            assert.equal(mathEnforcer.sum(-3, -4), -7);
        });
        it('should return the sum of a positive and a negative number', () => {
            assert.equal(mathEnforcer.sum(-3, 4), 1);
        });
        it('should return the sum of a floating point number and a positive number', () => {
            assert.equal(mathEnforcer.sum(5.5, 4), 9.5);
        });
        it('should return the sum of a floating point number and a negative number', () => {
            assert.equal(mathEnforcer.sum(5.5, -4), 1.5);
        });
        it('should return the sum of two floating point numbers', () => {
            assert.equal(mathEnforcer.sum(5.5, 4.5), 10);
        });
    });
});