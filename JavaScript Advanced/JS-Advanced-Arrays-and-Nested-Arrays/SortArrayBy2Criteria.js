function solve(arr) {
console.log(arr.sort((a, b) => a.length - b.length || a.localeCompare(b)).join('\n')); 
}
solve(['alpha', 
'beta', 
'gamma']
);
solve(['Isacc', 
'Theodor', 
'Jack', 
'Harrison', 
'George']

);
solve(['test', 
'Deny', 
'omen', 
'Default']
);
