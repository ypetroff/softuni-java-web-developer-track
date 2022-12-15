function sumFirstLast(input) {
    if(input.length === 0) {
        return 0;
    } else if(input.length === 1) {
        return Number(input[0]);
    } else {
       return Number(input.shift()) + Number(input.pop());  
    }
}
sumFirstLast(['20', '30', '40']);
sumFirstLast(['5', '10']);
sumFirstLast(['3']);
sumFirstLast([]);