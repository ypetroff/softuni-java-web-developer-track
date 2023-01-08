const {assert} = require('chai');
const isSymmetric = require('./checkForSymmetry');

describe('isSymmetric', () => {
    it('should return true if the array is symmetric - even elements', () => {
        assert.isTrue(isSymmetric([1, 2, 2, 1]));
        assert.isTrue(isSymmetric([1, 1]));    
    });
    it('should return true if the array is symmetric - odd elements', () => {
        assert.isTrue(isSymmetric([1, 2, 1]));
        assert.isTrue(isSymmetric([0]));
    });
    it('should return true if the array is symmetric - input is str', () => {
        assert.isTrue(isSymmetric(['1', '2', '1']));
        assert.isTrue(isSymmetric(['0']));
    });
    it('should return false if the array is not symmetric', () => {
        assert.isFalse(isSymmetric([1, 2, 3]));
    });
    it('should return false if the array is not an array', () => {
        assert.isFalse(isSymmetric(1));
        assert.isFalse(isSymmetric({}));
        assert.isFalse(isSymmetric(true));
        assert.isFalse(isSymmetric(false));
        assert.isFalse(isSymmetric(undefined));
        assert.isFalse(isSymmetric(null));
    }); 
    it('should return false if the array elements are not strictly equal', () => {
        assert.isFalse(isSymmetric(['1', 2, 1]));
    });
    it('should return false if the input is str', () => {
        assert.isFalse(isSymmetric('3a1a3'));
    });
});