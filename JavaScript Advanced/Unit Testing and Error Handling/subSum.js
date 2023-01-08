function subSum(arr, startIndex, endIndex) {
    if(!Array.isArray(arr)) {
        return NaN;
    }

    if(startIndex < 0 ||startIndex >= arr.length) {
    startIndex = 0;
    }

    if(endIndex < 0 || endIndex >= arr.length) {
    endIndex = arr.length - 1;
    }

    let sum = 0;

    try {
        for(let i = startIndex; i <= endIndex; i++) {
            sum += Number(arr[i]);
        }
    } finally {
        return sum;
    }
}

console.log(subSum([10, 'twenty', 30, 40], 0, 2));