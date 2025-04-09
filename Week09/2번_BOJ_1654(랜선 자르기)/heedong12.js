let [NK, ...nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, K] = NK.split(" ").map(Number);
nums = nums.map(Number);

let start = 0;
let end = Math.max(...nums);
let maxLen = 0;

while (start <= end) {
  let mid = Math.floor((start + end) / 2);
  let count = 0;
  for (let i = 0; i < nums.length; i++) {
    count += Math.floor(nums[i] / mid);
  }

  if (count < K) {
    end = mid - 1;
  } else {
    maxLen = Math.max(maxLen, mid);
    start = mid + 1;
  }
}

console.log(maxLen);
