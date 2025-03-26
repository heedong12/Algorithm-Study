let [N, nums, M] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
M = Number(M);

const set = new Set(nums.split(" ").map(Number));

let count = 0;

for (let num of set) {
  let target = M - num;

  if (set.has(target) && num !== target) {
    count++;
    set.delete(num);
    set.delete(target);
  }
}

console.log(count);
