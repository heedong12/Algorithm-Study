let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, k] = input.shift().split(" ").map(Number);
let kettles = input.map(Number);

let start = 1,
  end = Math.max(...kettles);
while (start <= end) {
  let mid = Math.floor((start + end) / 2);
  let cnt = 0;

  for (let k of kettles) {
    cnt += Math.floor(k / mid);
  }

  if (cnt >= k) {
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}

console.log(end);
