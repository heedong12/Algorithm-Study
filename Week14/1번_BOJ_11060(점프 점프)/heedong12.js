let [N, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
nums = nums.split(" ").map(Number);
let dp = new Array(N).fill(1001);
let canGo = true;
dp[0] = 0;

loop: for (let i = 0; i < N; i++) {
  for (let j = 0; j <= nums[i]; j++) {
    if (i + j >= N) break;
    // -1이 되는 경우
    if (dp[i + j] === 1001 && dp[i] === 1001) {
      canGo = false;
      break loop;
    }
    dp[i + j] = Math.min(dp[i] === 1001 ? 0 : dp[i] + 1, dp[i + j]);
  }
}

console.log(canGo ? dp[N - 1] : -1);
