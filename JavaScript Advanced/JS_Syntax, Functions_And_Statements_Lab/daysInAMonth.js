function daysMonth(month, year) {
let date = new Date(year, month, 0).getDate();
console.log(date);
}

daysMonth(1, 2012);
daysMonth(2, 2021);