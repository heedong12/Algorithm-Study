const [T, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const dp = Array.from({ length: 15 }, () => new Array(15));
const answer = [];

for (let j = 0; j < dp.length; j++) {
  for (let k = 0; k < dp[0].length; k++) {
    if (k <= 1) dp[j][k] = 1;
    else if (j === 0) dp[j][k] = k;
    else dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
  }
}

for (let i = 0; i < inputs.length; i = i + 2) {
  let K = inputs[i];
  let N = inputs[i + 1];

  answer.push(dp[K][N]);
}

console.log(answer.join("\n"));
