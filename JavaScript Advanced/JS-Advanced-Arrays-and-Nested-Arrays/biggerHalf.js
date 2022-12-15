function biggerHalf(inputArr) {
  return inputArr
    .sort((a, b) => b - a)
    .reverse()
    .slice(inputArr.length / 2, inputArr.length);
}
biggerHalf([4, 7, 2, 5]);
biggerHalf([3, 19, 14, 7, 2, 19, 6]);
