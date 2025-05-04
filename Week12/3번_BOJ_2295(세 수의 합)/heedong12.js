let [N, ...arr] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);
arr.sort((a, b) => a - b);
const set = new Set();

for (let i = 0; i < N; i++) {
  for (let j = i; j < N; j++) {
    set.add(arr[i] + arr[j]);
  }
}

let answer = 0;
outer: for (let i = N - 1; i >= 0; i--) {
  for (let j = 0; j <= i; j++) {
    const diff = arr[i] - arr[j];
    if (set.has(diff)) {
      answer = arr[i];
      break outer;
    }
  }
}

console.log(answer);
