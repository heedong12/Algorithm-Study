const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [a, b] = input[0].split(" ").map(Number);
const gap = a - b;
const n = Number(input[1]);

const left = [];
const right = [];
let [x, y] = [-2, -2];
let minScore = Number.MAX_SAFE_INTEGER;

for (let i = 2; i < 2 + n; i++) {
  const [leftValue, rightValue] = input[i].split(" ").map(Number);
  left.push([i - 1, leftValue]);
  right.push([i - 1, rightValue]);

  if (gap < leftValue && leftValue < minScore) {
    [x, y] = [i - 1, -1];
  }
  if (gap < rightValue && rightValue < minScore) {
    [x, y] = [-1, i - 1];
  }
}

if (gap < 0) {
  console.log("-1 -1");
  process.exit(0);
}

left.sort((a, b) => a[1] - b[1]);
right.sort((a, b) => a[1] - b[1]);

function binarySearch(idx, score, arr) {
  if (gap < score) return -1;

  let start = 0,
    end = arr.length;
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (gap < score + arr[mid][1]) {
      end = mid;
    } else {
      start = mid + 1;
    }
  }

  while (start < arr.length && arr[start][0] === idx) {
    start++;
  }

  return start < arr.length ? start : -2;
}

for (let i = 0; i < n; i++) {
  const [lIdx, lScore] = left[i];
  const [rIdx, rScore] = right[i];

  let findRIndex = binarySearch(lIdx, lScore, right);
  if (findRIndex !== -2) {
    let totalScore =
      b + lScore + (findRIndex === -1 ? 0 : right[findRIndex][1]);
    if (totalScore < minScore) {
      x = lIdx;
      y = findRIndex === -1 ? -1 : right[findRIndex][0];
      minScore = totalScore;
    }
  }

  let findLIndex = binarySearch(rIdx, rScore, left);
  if (findLIndex !== -2) {
    let totalScore = b + rScore + (findLIndex === -1 ? 0 : left[findLIndex][1]);
    if (totalScore < minScore) {
      x = findLIndex === -1 ? -1 : left[findLIndex][0];
      y = rIdx;
      minScore = totalScore;
    }
  }
}

console.log(x === -2 ? "No" : `${x} ${y}`);
