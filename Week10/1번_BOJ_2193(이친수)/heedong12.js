let N = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();
N = Number(N);

const dp = new Array(N).fill(0n);

dp[0] = 1n;
dp[1] = 1n;

for (let i = 2; i < N; i++) {
  dp[i] = dp[i - 1] + dp[i - 2];
}

console.log(dp[N - 1].toString());
