let N = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);

let dp = Array.from({ length: N }, () => new Array(3).fill(0));

dp[0][0] = 1;
dp[0][1] = 1;
dp[0][2] = 1;

for (let i = 1; i < N; i++) {
  dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
  dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
  dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
}

let result = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901;
console.log(result);
