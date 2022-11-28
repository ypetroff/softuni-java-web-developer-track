const { assert } = require("chai");
const { carService } = require("./03. Car service_Resources");

describe("Test carService", () => {
  describe("Test isItExpensive", () => {
    it("Should return expected output - happy path", () => {
      assert.equal(
        carService.isItExpensive("Engine"),
        "The issue with the car is more severe and it will cost more money"
      );
      assert.equal(
        carService.isItExpensive("Transmission"),
        "The issue with the car is more severe and it will cost more money"
      );
      assert.equal(
        carService.isItExpensive("a"),
        "The overall price will be a bit cheaper"
      );
    });
    // it('Should ', () => {
    //     assert
    // });
    // it('Should ', () => {
    //     assert
    // });
  });
  describe("Test discount", () => {
    it("Should work as expected - happy path", () => {
      assert.equal(carService.discount(1, 1), "You cannot apply a discount");
      assert.equal(carService.discount(2, 2), "You cannot apply a discount");
      assert.equal(
        carService.discount(1.5, 2.2),
        "You cannot apply a discount"
      );
      assert.equal(
        carService.discount(3, 100),
        "Discount applied! You saved 15$"
      );
      assert.equal(
        carService.discount(7, 100),
        "Discount applied! You saved 15$"
      );
      assert.equal(
        carService.discount(10, 100),
        "Discount applied! You saved 30$"
      );
      assert.equal(
        carService.discount(10.5, 100.0),
        "Discount applied! You saved 30$"
      );
    });
    it("Should throw invalid input if param1 is NaN", () => {
      assert.throws(() => carService.discount("1", 1), "Invalid input");
      assert.throws(() => carService.discount([], 1), "Invalid input");
      assert.throws(() => carService.discount({}, 1), "Invalid input");
    });
    it("Should throw invalid input if param2 is NaN", () => {
      assert.throws(() => carService.discount(1, ""), "Invalid input");
      assert.throws(() => carService.discount(1, []), "Invalid input");
      assert.throws(() => carService.discount(1, {}), "Invalid input");
    });
  });
  describe("Test partsToBuy", () => {
    const partsCatalogue = [
      { part: "a", price: 1 },
      { part: "b", price: 1.1 },
    ];
    it("Should work as expected happy path", () => {
      assert.equal(carService.partsToBuy(partsCatalogue,['a']), 1);
      assert.equal(carService.partsToBuy(partsCatalogue,['a', 'b']), 2.1);
      assert.equal(carService.partsToBuy([],['a']), 0);
      assert.equal(carService.partsToBuy(partsCatalogue,['c']), 0);
    });
    it("Should throw invalid input if param1 is not arr", () => {
      assert.throws(() => carService.partsToBuy('a', []), 'Invalid input');
      assert.throws(() => carService.partsToBuy(1, []), 'Invalid input');
      assert.throws(() => carService.partsToBuy(1.1, []), 'Invalid input');
      assert.throws(() => carService.partsToBuy({}, []), 'Invalid input');
    });
    it("Should throw invalid input if param2 is not arr", () => {
        assert.throws(() => carService.partsToBuy([], 'a'), 'Invalid input');
        assert.throws(() => carService.partsToBuy([], 1), 'Invalid input');
        assert.throws(() => carService.partsToBuy([], 1.1), 'Invalid input');
        assert.throws(() => carService.partsToBuy([], {}), 'Invalid input');
    });
  });
});
