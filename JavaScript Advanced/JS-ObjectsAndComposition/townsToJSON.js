function solve(input) {
  const line = (str) =>
    str
      .split("|")
      .filter((x) => x !== "")
      .map((x) => x.trim())
      .map((x) => (isNaN(x) ? x : Number(Number(x).toFixed(2))));
  const headings = line(input[0]);

  return JSON.stringify(
    input.slice(1).map((x) => {
      const currentLine = line(x);
      return headings.reduce((row, heading, entry) => {
        row[heading] = currentLine[entry];
        return row;
      }, {});
    })
  );
}
/*solve([
  "| Town | Latitude | Longitude |",
  "| Sofia | 42.696552 | 23.32601 |",
  "| Beijing | 39.913818 | 116.363625 |",
]);*/
solve([
  "| Town | Latitude | Longitude |",
  "| Veliko Turnovo | 43.0757 | 25.6172 |",
  "| Monatevideo | 34.50 | 56.11 |",
]);
