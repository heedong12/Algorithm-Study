const [n, l, w, h] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let start = 0,
  end = Math.min(l, w, h);

while (start < end) {
  let mid = (start + end) / 2;

  if (Math.floor(l / mid) * Math.floor(w / mid) * Math.floor(h / mid) < n) {
    if (end === mid) {
      break;
    }
    end = mid;
  } else {
    if (start === mid) {
      break;
    }
    start = mid;
  }
}

console.log(start);
