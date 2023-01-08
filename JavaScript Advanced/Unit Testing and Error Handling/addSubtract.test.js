const {assert} = require('chai');
const {createCalculator} = require('./addSubtract');

describe('createCalculator', () => {
   
    it('should return object', () => {
       const calc = createCalculator();
        assert.isObject(calc);
    });
    it('should return object with add method', () => {
        const calc = createCalculator();
         assert.isFunction(calc.add);  
     });
     it('should return object with  subtract method', () => {
        const calc = createCalculator();
         assert.isFunction(calc.subtract);
       
     });
     it('should return object with get method', () => {
        const calc = createCalculator();
         assert.isFunction(calc.get);
     });
       
    it('should return 0 if no arguments are passed', () => {
       const calc = createCalculator();
        assert.equal(calc.get(), 0);
    });
    it('should return 1 if 1 argument is added', () => {
       const calc = createCalculator();
        calc.add(1);
        assert.equal(calc.get(), 1);
    });
    it('should return 1 if 2 is added and 1 is subtracted', () => {
         const calc = createCalculator();
         calc.add(2);
          calc.subtract(1);
          assert.equal(calc.get(), 1);
    });
    it('should throw error if we try to modify the sum from the outside', () => {
        assert.isUndefined(createCalculator().value);
    });
    it('should parse the arguments to number', () => {
        const calc = createCalculator();
        calc.add('1');
        calc.add('3');
        assert.equal(calc.get(), 4);
    });
});