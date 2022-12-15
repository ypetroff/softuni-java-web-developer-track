function lastNumSeq(n, k) {
    let length = Number(n)
    let range = Number(k);
    let outputArr = [1];

    for (let index = 1; index < length; index++) {
         
        const tempArr = outputArr.slice(Math.max(0, index - range), index)
        outputArr.push(tempArr.reduce((a, b) => a + b));
    }
    return outputArr
}
lastNumSeq(6, 3);
lastNumSeq(8, 2);