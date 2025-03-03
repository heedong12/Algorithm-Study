const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const t = Number(input.shift());
const dp = Array.from(Array(15), () => Array(15).fill(1));

for (let i = 0; i < 15; i++) {
  dp[0][i] = i;
}

for (let i = 1; i < 15; i++) {
  dp[i][1] = 1;
  for (let j = 2; j < 15; j++) {
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
  }
}

let res = "";
for (let i = 0; i < t; i++) {
  const k = Number(input.shift());
  const n = Number(input.shift());
  res += dp[k][n] + "\n";
}

console.log(res);
