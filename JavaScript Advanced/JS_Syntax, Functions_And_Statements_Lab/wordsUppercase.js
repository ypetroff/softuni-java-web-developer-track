function wordsUppercase(input = '') {
    const regex = /[0-9A-z]+/g;

let msg = input.match(regex);
console.log(msg.join(', ').toUpperCase());

}
wordsUppercase('Hi, how are you?');