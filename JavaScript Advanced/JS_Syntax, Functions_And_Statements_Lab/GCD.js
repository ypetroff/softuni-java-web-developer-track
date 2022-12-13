function GCD(a, b) {
  let divisor = 1;
  let gcd = 1;

  while (divisor <= b) {
    if (a % divisor === 0 && b % divisor === 0) {
      gcd = divisor;
    }
    divisor++;
  }

  console.log(gcd);
}
GCD(15, 5);
GCD(2154, 458);
