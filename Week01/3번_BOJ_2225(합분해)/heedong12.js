const [N, K] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const DP = Array.from({ length: N + 1 }, () => Array(K + 1).fill(1));

for (let i = 1; i <= N; i++) {
  for (let j = 2; j <= K; j++) {
    DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % 1000000000;
  }
}

console.log(DP[N][K]);
