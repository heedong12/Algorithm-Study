let [N, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
nums = nums
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let map = new Map();
nums.forEach((item) => {
  map.set(item, (map.get(item) ?? 0) + 1);
});

let result = 0;

for (let i = 0; i < N; i++) {
  const target = nums[i];
  // 사전에 하나 빼두기
  map.set(target, map.get(target) - 1);

  // a + b = c(-> target)
  for (let j = 0; j < N; j++) {
    if (i === j) continue;
    let a = nums[j];
    let b = target - a;

    if (map.has(b)) {
      if (b === target && map.get(b) < 1) {
        continue;
      }
      if (a === b && map.get(b) < 2) {
        continue;
      }

      if (map.get(b) > 0) {
        result++;
        break;
      }
    }
  }

  map.set(target, map.get(target) + 1);
}
console.log(result);
