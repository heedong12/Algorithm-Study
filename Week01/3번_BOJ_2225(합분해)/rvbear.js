const [N, K] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map(Number);

const MOD = 1000000000;

let dp = Array.from(Array(N + 1), () => new Array(K + 1).fill(1));

for (let i = 1; i <= N; i++) {
  for (let j = 2; j <= K; j++) {
    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
  }
}

console.log(dp[N][K] % MOD);