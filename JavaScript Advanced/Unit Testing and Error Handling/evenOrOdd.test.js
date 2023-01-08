const {assert} = require('chai');
const {isOddOrEven} = require('./evenOrOdd');

describe('isOddOrEven', () => {
    it('should return even when \'hello!\' string is received as an input', () => {
        assert.equal(isOddOrEven('hello!'), 'even');
    });
    it('should return odd when \'hi!\' string is received as an input', () => {
        assert.equal(isOddOrEven('hi!'), 'odd');
    });
    it('should return undefined when the input is not a string is received as an input', () => {
        assert.isUndefined(isOddOrEven([]));
    });
    it('should return correct output with multiple strins received as an input', () => {
        assert.equal(isOddOrEven('Pepi'), 'even');
        assert.equal(isOddOrEven('JS'), 'even');
        assert.equal(isOddOrEven('SoftUni'), 'odd');
        assert.equal(isOddOrEven('Nakov'), 'odd');
    });
});