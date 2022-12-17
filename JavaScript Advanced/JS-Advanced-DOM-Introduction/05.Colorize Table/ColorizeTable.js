function colorize() {
Array.from(document.querySelectorAll('table tr:nth-child(even)')).forEach(x => x.style.backgroundColor = 'teal');
}