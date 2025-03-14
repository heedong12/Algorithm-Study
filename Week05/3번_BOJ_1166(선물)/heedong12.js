const [N, L, W, H] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let start = 0;
let end = Math.min(L, W, H);
let mid = 0;

while (start <= end) {
  mid = (start + end) / 2;
  if (Math.floor(L / mid) * Math.floor(W / mid) * Math.floor(H / mid) < N) {
    if (end === mid) break;
    end = mid;
  } else {
    if (start === mid) break;
    start = mid;
  }
}

console.log(mid);
