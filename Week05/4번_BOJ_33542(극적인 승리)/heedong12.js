const [scores, N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [A, B] = scores.split(" ").map(Number);
const targets = inputs.map((row) => row.split(" ").map(Number));

let minWinScore = A + 1;
let bestScore = Infinity;
let bestLeft = -1;
let bestRight = -1;

const rightSorted = targets
  .map((target, index) => ({
    score: target[1],
    index,
  }))
  .sort((a, b) => a.score - b.score);

for (let left = -1; left < N; left++) {
  let leftScore = left === -1 ? 0 : targets[left][0];
  let neededScore = minWinScore - B - leftScore;

  let start = 0;
  let end = N - 1;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let rightScore = rightSorted[mid].score;
    let rightIndex = rightSorted[mid].index;

    if (rightScore >= neededScore && rightIndex !== left) {
      if (B + leftScore + rightScore < bestScore) {
        bestScore = B + leftScore + rightScore;
        bestLeft = left;
        bestRight = rightIndex;
      }
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

  if (B + leftScore >= minWinScore && B + leftScore < bestScore) {
    bestScore = B + leftScore;
    bestLeft = left;
    bestRight = -1;
  }
}

if (B >= minWinScore && B < bestScore) {
  bestScore = B;
  bestLeft = -1;
  bestRight = -1;
}

if (bestScore === Infinity) {
  console.log("No");
} else {
  console.log(
    `${bestLeft === -1 ? -1 : bestLeft + 1} ${
      bestRight === -1 ? -1 : bestRight + 1
    }`
  );
}
