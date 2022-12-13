function circleArea(input) {
  let radius;

  


  if (typeof input !== 'number') {
    console.log(   
      `We can not calculate the circle area, because we receive a ${typeof input}.`
    );
  } else {
    radius = Number(input);
    const exponent = 2;
    let area = Math.PI * Math.pow(radius, exponent);
    console.log(area.toFixed(2));
  }
}
circleArea(5);
circleArea("name");
circleArea('2.5');
circleArea(0);
