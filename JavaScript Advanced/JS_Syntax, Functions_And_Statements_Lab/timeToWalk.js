function timeToWalk(steps, footprint, speed) {
  const distance = Number(steps) * Number(footprint);
  const breakTime = Math.floor(distance / 500) * 60;
  const time = Math.round(distance / speed * 3.6 + breakTime);
  
  let seconds = time % 60;
  let minutes = ((time - seconds) / 60) % 60;
  let hours =((time - seconds - minutes  * 60) / 60) % 60;

  seconds = leadingZero(seconds);
  minutes = leadingZero(minutes);
  hours = leadingZero(hours);

 console.log(`${hours}:${minutes}:${seconds}`);

 function leadingZero(num) {
     if(num >= 0 && num <= 9) {
         num = '0' + num;  
     }
   return num; 
 }
 
}
timeToWalk(4000, 0.6, 5);
timeToWalk(2564, 0.70, 5.5);
