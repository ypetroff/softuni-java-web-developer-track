function dayOfWeek(input) {
  const days = new Set([
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday",
  ]);
  let day = [...days].indexOf(input);

  if (day === -1) {
    console.log('error');
  } else {
    console.log(day + 1);
  }
}
dayOfWeek("Monday");
dayOfWeek("Invalid");
dayOfWeek('Friday');
dayOfWeek('Frabjoyousday');
