let n = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim();

let dp = [BigInt(0), BigInt(1)];

for (let i = 2; i <= +n; i++) {
  dp.push(dp[i - 1] + dp[i - 2]);
}

console.log(dp[n].toString());
