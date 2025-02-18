const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const DP = [0n, 1n];
for (let i = 2; i <= input; i++) {
  DP[i] = DP[i - 1] + DP[i - 2];
}

console.log(DP[input].toString());
