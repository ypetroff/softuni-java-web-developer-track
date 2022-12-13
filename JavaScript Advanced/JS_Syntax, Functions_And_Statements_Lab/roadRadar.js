function roadRadar(speed, area) {
  let withinSpeedLimit = new Boolean(true);
  let speedLimit;
  let driverSpeed = Number(speed);

  switch (area) {
    case "motorway":
        speedLimit = 130;
        checkSpeedLimit(driverSpeed, speedLimit);
      break;
    case "interstate":
        speedLimit = 90;
        checkSpeedLimit(driverSpeed, speedLimit);
      break;
    case "city":
        speedLimit = 50;
        checkSpeedLimit(driverSpeed, speedLimit);
      break;
    case "residential":
        speedLimit = 20;
        checkSpeedLimit(driverSpeed, speedLimit);
      break;
  }

  if(withinSpeedLimit) {
      console.log(`Driving ${driverSpeed} km/h in a ${speedLimit} zone`);
  } else {
      let status;
      let speedDifference = driverSpeed - speedLimit;

      if(speedDifference <= 20) {
          status = 'speeding';
      } else if(speedDifference <= 40) {
          status = 'excessive speeding';
      } else {
          status = 'reckless driving';
      }
      console.log(`The speed is ${speedDifference} km/h faster than the allowed speed of ${speedLimit} - ${status}`);
  }

  function checkSpeedLimit(driverSpeed, speedLimit) {
    if (driverSpeed > speedLimit) {
      withinSpeedLimit = false;
    }
  }
}



roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway')
roadRadar('130', 'motorway');
