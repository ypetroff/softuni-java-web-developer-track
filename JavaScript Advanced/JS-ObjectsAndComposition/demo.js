// function rectangle(width, height, color) {
//   return {
//     width: Number(width),
//     height: Number(height),
//     color: color.charAt(0).toUpperCase() + color.slice(1),
//     calcArea() {
//       return this.width * this.height;
//     }
//   }
// }


// let rect = rectangle(4, 5, "red");
// console.log(rect.width);
// console.log(rect.height);
// console.log(rect.color);
// let test = rect.calcArea();
// console.log(rect.calcArea());

function rectangle(width, height, color) {

  const obj = {
    width: Number(width),
    height: Number(height),
    color: color[0].toUpperCase() + color.slice(1),
    calcArea: () => {
      return this.width * this.height;
    },
  };

  return obj;
}

let rect = rectangle(4, 5, "red");
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
let test = rect.calcArea();
console.log(rect.calcArea());
