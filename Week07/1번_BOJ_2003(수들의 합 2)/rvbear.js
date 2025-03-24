const [input, num] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input.trim().split(" ").map(Number);
const numList = num.trim().split(" ").map(Number);

let start = 0,
  end = 0,
  sum = 0,
  cnt = 0;
while (end < n) {
  sum += numList[end++];

  while (sum > m && start < end) {
    sum -= numList[start++];
  }

  if (sum === m) {
    cnt++;
  }
}

console.log(cnt);
