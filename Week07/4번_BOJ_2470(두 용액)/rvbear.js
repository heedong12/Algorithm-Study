let [n, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let arr = input
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let min = Number.MAX_SAFE_INTEGER;
let left = 0,
  right = n - 1,
  ansLeft = 0,
  ansRight = 0;
while (left < right) {
  let temp = arr[left] + arr[right];

  if (Math.abs(temp) < min) {
    min = Math.abs(temp);
    ansLeft = arr[left];
    ansRight = arr[right];
  }

  if (temp < 0) {
    left++;
  } else {
    right--;
  }
}

console.log(ansLeft, ansRight);
