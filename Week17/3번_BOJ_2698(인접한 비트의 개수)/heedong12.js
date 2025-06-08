let [T, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

T = Number(T);
let answer = [];
let dp = Array.from({ length: 101 }, () =>
  Array.from({ length: 101 }, () => [0, 0])
);

dp[1][0][0] = 1;
dp[1][0][1] = 1;

for (let i = 2; i <= 100; i++) {
  for (let j = 0; j <= 100; j++) {
    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];

    if (j > 0) {
      dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
    } else {
      dp[i][j][1] = dp[i - 1][j][0];
    }
  }
}

for (let i = 0; i < T; i++) {
  const [n, k] = inputs[i].split(" ").map(Number);
  answer.push(dp[n][k][0] + dp[n][k][1]);
}

console.log(answer.join("\n"));
