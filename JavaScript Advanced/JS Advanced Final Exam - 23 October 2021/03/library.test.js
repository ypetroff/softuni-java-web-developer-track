const { assert } = require('chai');
const { library } = require('./library');

describe('Test Library', () => {
    describe('Test calcPriceOfBook', () => {
        it('Should return as expected - happy path', () => {
            assert.equal(library.calcPriceOfBook('a', 1), 'Price of a is 10.00');
            assert.equal(library.calcPriceOfBook('a', 1980), 'Price of a is 10.00');
            assert.equal(library.calcPriceOfBook('a', 1981), 'Price of a is 20.00');
        });
        it('Should throw invalid input if param 1 is not a string', () => {
            assert.throws(() => library.calcPriceOfBook(1, 1), "Invalid input");
            assert.throws(() => library.calcPriceOfBook({}, 1), "Invalid input");
            assert.throws(() => library.calcPriceOfBook([], 1), "Invalid input");
        });
        it('Should throw invalid input if param 2 is not an int', () => {
            assert.throws(() => library.calcPriceOfBook('a', 1.1), "Invalid input");
            assert.throws(() => library.calcPriceOfBook('a', '1'), "Invalid input");
            assert.throws(() => library.calcPriceOfBook('a', []), "Invalid input");
            assert.throws(() => library.calcPriceOfBook('a', {}), "Invalid input");
        });
    });
    describe('Test findBook', () => {
        it('Should return as expected - happy path', () => {
            assert.equal(library.findBook(['a'], 'a'), "We found the book you want.");
            assert.equal(library.findBook(['a', 'b'], 'a'), "We found the book you want.");
        });
        it('Should return the book is not here', () => {
            assert.equal(library.findBook(['a'], 'c'), "The book you are looking for is not here!");
            assert.equal(library.findBook(['a', 'b'], 'c'), "The book you are looking for is not here!");
        });
        it('Should throw no books currently available', () => {
            assert.throws(() => library.findBook([], 'a'), "No books currently available");
        });
    });
    describe('Test arrangeTheBooks', () => {
        it('Should return as expected - happy path', () => {
            assert.equal(library.arrangeTheBooks(0), "Great job, the books are arranged.");
            assert.equal(library.arrangeTheBooks(1), "Great job, the books are arranged.");
            assert.equal(library.arrangeTheBooks(40), "Great job, the books are arranged.");
        });
        it('Should return insufficient space...', () => {
            assert.equal(library.arrangeTheBooks(41), "Insufficient space, more shelves need to be purchased.");
            assert.equal(library.arrangeTheBooks(400), "Insufficient space, more shelves need to be purchased.");
        });
        it('Should throw invalid input', () => {
            assert.throws(() => library.arrangeTheBooks(1.1), "Invalid input");
            assert.throws(() => library.arrangeTheBooks(-1), "Invalid input");
            assert.throws(() => library.arrangeTheBooks(-1.1), "Invalid input");
        });
    });
});