function createSortedList() {
  
    let numbers = [];
   
   function add(element) {
      numbers.push(element);
      numbers.sort((a, b) => a-b);
      this.size++;

    }
   function remove(index) {
      if (verifyIndex(index)) {
       numbers.splice(index, 1);
       this.size--;
      }
    }
   function get(index) {
      if (verifyIndex(index)) {
        return numbers[index];
      }
  };

  function verifyIndex(index) {
    return index >= 0 && index < numbers.length;
  }

  return {
    size: 0,
    add,
    remove,
    get,
  }
}
 let list = createSortedList();
 console.log(list.size);
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));

// var myList = result();
// expect(myList.hasOwnProperty('size')).to.equal(true, "Property size was not found");

// // Generate random list of 20 numbers
// var expectedArray = [];
// for (let i = 0; i < 20; i++) {
//     expectedArray.push(Math.floor(Math.random() * 200) - 100);
// }
// // Add to collection
// for (let i = 0; i < expectedArray.length; i++) {
//     myList.add(expectedArray[i]);
// }
// expect(myList.size).to.equal(20, "Elements weren't added");
// // Sort array
// expectedArray.sort((a, b) => a - b);
// // Compare with collection
// for (let i = 0; i < expectedArray.length; i++) {
//     expect(myList.get(i)).to.equal(expectedArray[i], "Array wasn't sorted");
// }


// function createSortedList() {

//   const isValid = (index, arr) => index >= 0 && index < arr.length;

//   return {
//     list: [],
//     size: 0,
//     add(element) {
//       this.list.push(Number(element));
//       this.list = this.list.sort((a, b) => a - b);
//       this.size = this.list.length;
//     },
//     remove(index) {
//       if (isValid(index, this.list)) {
//         this.list.splice(index, 1)
//       }
//       this.size = this.list.length;
//     },
//     get(index) {
//       if (isValid(index, this.list)) {
//         return this.list[index];
//       }
//     }
//   };
// }