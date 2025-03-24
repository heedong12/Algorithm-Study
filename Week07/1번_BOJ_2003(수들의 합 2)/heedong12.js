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

while (start <= end && start < N && end < N) {
  if (sum < M) {
    end++;
    sum += arr[end];
  } else if (sum > M) {
    if (start === end && end + 1 < N) {
      end++;
      sum += arr[end];
    } else {
      sum -= arr[start];
      start++;
    }
  } else if (sum === M) {
    count++;
    end++;
    sum += arr[end];
  }
}

console.log(count);
