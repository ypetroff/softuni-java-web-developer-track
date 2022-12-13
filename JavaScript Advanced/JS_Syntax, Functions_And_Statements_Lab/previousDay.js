function prevDay(year, month, day) {

    let date = new Date(`${year}-${month}-${day}`);
    const prev = new Date(date);
    prev.setDate(date.getDate() - 1);

    console.log(`${prev.getFullYear()}-${prev.getMonth() + 1}-${prev.getDate()}`);

}
prevDay(2016, 9, 30);
prevDay(2016, 10, 1);