let [N, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
nums = nums.split(" ").map(Number);

const dp = new Array(N).fill(1);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < i; j++) {
    if (nums[i] > nums[j]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}

console.log(Math.max(...dp));
