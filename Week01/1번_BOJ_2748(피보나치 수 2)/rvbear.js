let input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

let n = Number(input[0]);
const dp = [0, 1];

for (let i = 2; i < n + 1; i++) {
  dp[i] = BigInt(dp[i - 1]) + BigInt(dp[i - 2]);
}

console.log(dp[n].toString());
