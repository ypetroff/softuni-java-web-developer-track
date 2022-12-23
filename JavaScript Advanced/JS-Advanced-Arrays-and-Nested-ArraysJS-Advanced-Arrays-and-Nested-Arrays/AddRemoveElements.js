function solve(input) {
  let output = [];

  for (let i = 0; i < input.length; i++) {
    if (input[i] === 'add') {
      output.push(i + 1);
    } else if (output.length > 0) {
      output.pop();
    } 
  }

  if(output.length < 1) {
      console.log('Empty');
  } else {
     output.forEach(x => console.log(x)); 
  }
  
}
solve(["remove", "remove", "remove"]);
solve(["add", "add", "add", "add"]);
solve(["add", "add", "remove", "add", "add"]);
