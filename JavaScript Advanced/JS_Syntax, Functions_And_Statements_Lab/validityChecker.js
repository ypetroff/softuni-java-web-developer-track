function validityChecker(c1, c2, c3, c4) {
  let x1 = Number(c1);
  let y1 = Number(c2);
  let x2 = Number(c3);
  let y2 = Number(c4);
  let pointsAreValid = '';

  validateTwoPoints(x1, y1, 0, 0);
  validateTwoPoints(x2, y2, 0, 0);
  validateTwoPoints(x1, y1, x2, y2);

  function validateTwoPoints(x1, y1, x2, y2) {
    let pointsCheck = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    pointsAreValid = Number.isInteger(pointsCheck) ? "valid" : "invalid";
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${pointsAreValid}`);
  }
}
validityChecker(3, 0, 0, 4);
validityChecker(2, 1, 1, 1);