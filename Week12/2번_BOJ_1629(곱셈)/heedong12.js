let [A, B, C] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

const solve = (a, b, c) => {
  if (b === 0n) return 1n;

  let answer = solve(a, b / 2n, c);
  let result = (answer * answer) % c;

  if (b % 2n === 0n) {
    return result;
  } else {
    return (result * a) % c;
  }
};

console.log(solve(A, B, C).toString());
