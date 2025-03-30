let [N, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

nums = nums
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let min = Number.MAX_SAFE_INTEGER;
let answer = "";
let start = 0;
let end = N - 1;

while (start < end) {
  let sum = nums[start] + nums[end];
  let diff = Math.abs(sum);

  min = Math.min(min, diff);
  if (min === diff) answer = `${nums[start]} ${nums[end]}`;

  if (sum < 0) start++;
  else if (sum > 0) end--;
  else if (sum === 0) {
    answer = `${nums[start]} ${nums[end]}`;
    break;
  }
}

console.log(answer);
