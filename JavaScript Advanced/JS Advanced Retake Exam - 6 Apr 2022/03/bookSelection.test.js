const {assert} = require('chai');
const {bookSelection} = require ('./bookSelection');

describe('Book Selection Tests', () => {
   describe('isGenreSuitable', () => {
    it('Should return the book is suitable for non thriller and horror', () => {
        assert.equal(bookSelection.isGenreSuitable('Classic', 5), 'Those books are suitable');
        assert.equal(bookSelection.isGenreSuitable('Classic', 15), 'Those books are suitable');
    });

    it('Should return not suitable for thriller or horror', () => {
        assert.equal(bookSelection.isGenreSuitable('Thriller', 5),
        'Books with Thriller genre are not suitable for kids at 5 age');
        assert.equal(bookSelection.isGenreSuitable('Horror', 5),
        'Books with Horror genre are not suitable for kids at 5 age');
    });

    it('Should return suitable books for horror and thriller if age is above 12', () => {
        assert.equal(bookSelection.isGenreSuitable('Horror', 15), 'Those books are suitable');
        assert.equal(bookSelection.isGenreSuitable('Thriller', 15), 'Those books are suitable');
    });

   });
   describe('isItAffordable', () => {
    it('Should throw if price is NaN, budget is number', () => {
        assert.throws(() => bookSelection.isItAffordable('33', 150), 'Invalid input');
    });
    it('Should throw if price is number, budget is NaN', () => {
        assert.throws(() => bookSelection.isItAffordable(33, '150'), 'Invalid input');
    });
    it('Should throw if price and budget are NaN', () => {
        assert.throws(() => bookSelection.isItAffordable('33', '150'), 'Invalid input');
    });
    it('Should return not enough money if budget is less than price', () => {
        assert.equal(bookSelection.isItAffordable(333, 150), 'You don\'t have enough money');
    });
    it('Should return book bought if budget is more or equal to price', () => {
        assert.equal(bookSelection.isItAffordable(33, 150),
        `Book bought. You have ${150 - 33}$ left`);
        assert.equal(bookSelection.isItAffordable(1, 1),
        'Book bought. You have 0$ left');
    });
   });
   describe('suitableTitles', () => {
    it('Should throw if first input is not an array', () => {
        assert.throws(() => bookSelection.suitableTitles(1, 'str'), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles({}, 'str'), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles('a', 'str'), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles('aa', 'str'), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles(()=> {}, 'str'), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles('str'), 'Invalid input');
    });
    it('Should throw if second input is not a string', () => {
        assert.throws(() => bookSelection.suitableTitles([], 1), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles([], {}), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles([], []), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles([], ()=> {}), 'Invalid input');
        assert.throws(() => bookSelection.suitableTitles([]), 'Invalid input');
    });
    it('Shouw throw if there are no params to the function', () => {
        assert.throws(() => bookSelection.suitableTitles(), 'Invalid input');
    });
    it('Shouw throw if there are both params are wrong', () => {
        assert.throws(() => bookSelection.suitableTitles('str', []), 'Invalid input');
    });
    it('Should return the requested book based on genre', () => {
        assert.deepEqual(bookSelection.suitableTitles([
            {title: 'book', genre: 'a'}
        ], 'a'), ['book']);
        assert.deepEqual(bookSelection.suitableTitles([
            {title: 'book',
            genre: 'a'},
            {title: 'book2',
                genre: 'a2'}
        ], 'a'), ['book']);
        assert.deepEqual(bookSelection.suitableTitles([
            {title: 'book', genre: 'a'}
        ], 'b'), []);
    });
   });
});



// it('Should ', () => {
   
// });