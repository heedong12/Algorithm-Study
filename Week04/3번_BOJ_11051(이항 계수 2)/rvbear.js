let [n, k] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

let res = 1n;
let div = 1n;

k = n - k < k ? n - k : k;

while (k--) {
  res *= n;
  res /= div;

  n -= 1n;
  div += 1n;
}

console.log((res % 10007n).toString());
