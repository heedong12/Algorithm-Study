let [num, arr] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
const [N, M] = num.split(" ").map(Number);
arr = arr.split(" ").map(Number);

let start = 0;
let end = 0;
let sum = arr[0];
let count = 0;

while (end < N) {
  if (sum < M) {
    sum += arr[++end];
  } else if (sum > M) {
    sum -= arr[start++];
  } else {
    count++;
    sum += arr[++end];
  }
}

console.log(count);
