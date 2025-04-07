let [N, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
nums = nums.split(" ").map(Number);

let answer = [nums[0]];

const findIndex = (target) => {
  let start = 0;
  let end = answer.length;

  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (target > answer[mid]) {
      start = mid + 1;
    } else {
      end = mid;
    }
  }

  return end;
};

for (let i = 1; i < N; i++) {
  if (answer[answer.length - 1] < nums[i]) answer.push(nums[i]);
  else if (answer[answer.length - 1] > nums[i])
    answer[findIndex(nums[i])] = nums[i];
}

console.log(answer.length);
