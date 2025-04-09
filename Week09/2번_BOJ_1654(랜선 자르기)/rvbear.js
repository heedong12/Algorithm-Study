let [input, ...num] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [k, n] = input.trim().split(" ").map(Number);
num = num.map(Number);
let max = Math.max(...num),
  min = 0;

while (min <= max) {
  let cnt = 0;
  let mid = Math.floor((min + max) / 2);

  for (let i = 0; i < k; i++) {
    cnt += Math.floor(num[i] / mid);
  }

  if (cnt < n) {
    max = mid - 1;
  } else {
    min = mid + 1;
  }
}

console.log(Math.floor((max + min) / 2));
