let [a, b, c] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

let ans = 1n;

while (b > 0n) {
  if (b % 2n === 1n) {
    ans = (ans * a) % c;
  }
  a = (a * a) % c;
  b /= 2n;
}

console.log(ans.toString());
