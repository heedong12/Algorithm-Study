const [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const answer = [];
for (let i = 0; i < n; i++) {
  let dp = new Array(input[i] + 1);
  dp = [0, 1, 2, 4];

  for (let j = 4; j <= input[i]; j++) {
    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
  }
  answer.push(dp[input[i]]);
}

console.log(answer.join("\n"));
