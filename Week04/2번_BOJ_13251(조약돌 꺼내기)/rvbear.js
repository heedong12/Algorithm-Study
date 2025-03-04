const [m, input, k] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const color = input.split(" ").map(Number);
const total = color.reduce((pre, cur) => pre + cur);

let ans = 0;
color.forEach((c) => {
  if (c >= k) {
    let value = 1;

    for (let i = 0; i < k; i++) {
      value *= (c - i) / (total - i);
    }

    ans += value;
  }
});

console.log(ans);
