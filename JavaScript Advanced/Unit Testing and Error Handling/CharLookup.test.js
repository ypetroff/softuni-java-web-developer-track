const {assert} = require('chai');
const {lookupChar} = require('./CharLookup');

describe('lookupChar', () => {
    it('should be a function', () => {
        assert.isFunction(lookupChar);
    });
    //happy path
    it('should return the correct char when both parrameters are correct', () => {
        assert.equal(lookupChar('abc', 1), 'b');
    });
    //unhappy path
    
    it('should return undefined when the first parameter is not a string', () => {
        assert.isUndefined(lookupChar(1, 1));
    });
    it('should return undefined when the second parameter is not an integer', () => {
        assert.isUndefined(lookupChar('abc', '1k'));
    });
    it('should return undefined when the second parameter is floating point number', () => {
        assert.isUndefined(lookupChar(1, 1.1));
    });
    it('should return Incorrect index when the second parameter is not a positive integer', () => {
        assert.equal(lookupChar('abc', -1), 'Incorrect index');
    });
    it('should return Incorrect index when the second parameter is greater than the string length', () => {
        assert.equal(lookupChar('abc', 4), 'Incorrect index');
    });
     it('should return Incorrect index when the second parameter is equal to the string length', () => {
        assert.equal(lookupChar('abc', 3), 'Incorrect index');
    });
});