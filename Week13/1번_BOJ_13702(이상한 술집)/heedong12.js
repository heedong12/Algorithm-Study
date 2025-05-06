let [NK, ...volumes] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, K] = NK.split(" ").map(Number);
volumes = volumes.map(Number);

let start = 1;
let end = Math.max(...volumes);
let answer = 0;

while (start <= end) {
  let mid = Math.floor((start + end) / 2);

  let count = volumes.reduce((acc, cur) => acc + Math.floor(cur / mid), 0);

  if (count < K) {
    end = mid - 1;
  } else {
    start = mid + 1;
    answer = mid;
  }
}

console.log(answer);
