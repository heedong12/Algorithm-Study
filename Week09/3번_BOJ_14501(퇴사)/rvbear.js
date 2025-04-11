let [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = +n;
input = input.map((v) => v.split(" ").map(Number));
let dp = Array(n + 1).fill(0);

for (let i = n - 1; i >= 0; i--) {
  let temp = i + +input[i][0];

  if (temp <= n) {
    dp[i] = Math.max(input[i][1] + dp[temp], dp[i + 1]);
  } else {
    dp[i] = dp[i + 1];
  }
}

console.log(dp[0]);
