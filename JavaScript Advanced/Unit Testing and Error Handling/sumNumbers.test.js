const {assert} = require('chai');
const sum = require('./sumNumbers');

describe('sum', () => {
    it('should return the sum of the numbers in the array', () => {
        assert.equal(sum([1, 2, 3]), 6);
        assert.equal(sum([1, 2, 3, 4]), 10);
        assert.equal(sum([1, 2.5, 3.5, 4, 5]), 16);
    });

    it('should return 0 if the array is empty', () => {
        assert.equal(sum([]), 0);
    });

    it('should return NaN if the array contains a non-number', () => {
        assert.isNaN(sum([1, 2, 'a']));
    });
    
});