const { assert } = require('chai');
const { companyAdministration } = require('./companyAdministration');

describe('Test companyAdministration', () => {
    describe('Test hiringEmployee', () => {
        it('Should return the required output - happy path', () => {
            assert.equal(companyAdministration.hiringEmployee('a','Programmer', 3),
            'a was successfully hired for the position Programmer.');
            assert.equal(companyAdministration.hiringEmployee('a','Programmer', 4.5),
            'a was successfully hired for the position Programmer.');
        });
        it('Should return is not approved', () => {
            assert.equal(companyAdministration.hiringEmployee('a','Programmer', 2),
            'a is not approved for this position.');
            assert.equal(companyAdministration.hiringEmployee('a','Programmer', 2.9),
            'a is not approved for this position.');
            assert.equal(companyAdministration.hiringEmployee('a','Programmer', -2.9),
            'a is not approved for this position.');
        });
        it('Should throw We are not looking for workers', () => {
            assert.throws(() => companyAdministration.hiringEmployee('a','b', 3),
            'We are not looking for workers for this position.');
            assert.throws(() => companyAdministration.hiringEmployee('a','b', 1),
            'We are not looking for workers for this position.');
        });
    });
    describe('Test calculateSalary', () => {
        it('Should return expexted input - happy path', () => {
            assert.equal(companyAdministration.calculateSalary(1), 15);
            assert.equal(companyAdministration.calculateSalary(161), 3415);
            assert.equal(companyAdministration.calculateSalary(1.1), 16.5)
        });
        it('Should throw invalid hours', () => {
            assert.throws(() => companyAdministration.calculateSalary(-1), "Invalid hours");
            assert.throws(() => companyAdministration.calculateSalary([]), "Invalid hours");
            assert.throws(() => companyAdministration.calculateSalary({}), "Invalid hours");
            assert.throws(() => companyAdministration.calculateSalary('a'), "Invalid hours");
        });
    });
    describe('Test firedEmployee', () => {
        it('Should return exected output - happy path', () => {
            assert.equal(companyAdministration.firedEmployee(['a'], 0), "");
            assert.equal(companyAdministration.firedEmployee(['a', 'b'], 0), "b");
            assert.equal(companyAdministration.firedEmployee(['a', 'b', 'c'], 0), "b, c");
        });
        it('Should throw invalid input', () => {
            assert.throws(() => companyAdministration.firedEmployee('a', 0), "Invalid input");
            assert.throws(() => companyAdministration.firedEmployee(['a', 'b'], 1.1), "Invalid input");
            assert.throws(() => companyAdministration.firedEmployee(['a'], -1), "Invalid input");
            assert.throws(() => companyAdministration.firedEmployee(['a'], 1), "Invalid input");
            assert.throws(() => companyAdministration.firedEmployee(['a'], 2), "Invalid input");
        });
    });
});