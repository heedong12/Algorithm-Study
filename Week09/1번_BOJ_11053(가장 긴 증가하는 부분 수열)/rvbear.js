let [n, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let numList = [0, ...input.split(" ").map(Number)];
let dp = Array(n + 1).fill(1);

let max = 1;
for (let i = 2; i <= n; i++) {
  for (let j = 1; j < i; j++) {
    if (numList[i] > numList[j]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }

  max = Math.max(max, dp[i]);
}

console.log(max);
