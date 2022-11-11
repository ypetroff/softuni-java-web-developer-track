function solution() {
    let text = '';

    function append(str) {
        text = text += str;
    }

    function removeStart(num) {
        text = text.slice(num);
    }

    function removeEnd(num) {
        text = text.slice(0, -num);
    }

    function print() {
        console.log(text);
    }

    return {
        append,
        removeStart,
        removeEnd,
        print
    }
}


let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();
