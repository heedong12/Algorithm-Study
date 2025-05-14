let [n, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let a = input.split(" ").map(Number);
let dp = Array(+n).fill(Number.MAX_SAFE_INTEGER);

dp[0] = 0;

for (let i = 0; i < +n; i++) {
  if (dp[i] === Number.MAX_SAFE_INTEGER || a[i] === 0) {
    continue;
  }

  for (let j = 1; j <= a[i]; j++) {
    if (i + j < +n) {
      dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
    }
  }
}

console.log(dp[n - 1] === Number.MAX_SAFE_INTEGER ? -1 : dp[n - 1]);
