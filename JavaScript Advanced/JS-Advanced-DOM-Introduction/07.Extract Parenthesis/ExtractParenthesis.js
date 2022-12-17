function extract(id) {
    const regex = new RegExp(/(?<=\().+?(?=\))/g);

return document.getElementById(id).textContent.match(regex).join('; ');

    /*let text = Array.from(document.getElementById(id).textContent);
    
    let words = '';
    let output = [];
    let flag = false;
    for (const char of text) {
        if(char === '(') {
            flag = true; 
        } else if (char === ')') {
            output.push(words);
            words = '';
            flag = false;
        }

        if(flag && char !== '(') {
            words+=char;
        }
    }

    return output.join('; '); */

}