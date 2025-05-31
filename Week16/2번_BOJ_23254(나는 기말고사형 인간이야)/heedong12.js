let [NM, A, B] = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split("\n")
  .map((item) => item.split(" ").map(Number));

let [N, M] = NM;

N *= 24;

let scores = [];

for (let i = 0; i < M; i++) {
  let leftScore = 100 - A[i];
  let fullHours = Math.floor(leftScore / B[i]);
  let leftover = leftScore % B[i];

  for (let j = 0; j < fullHours; j++) {
    scores.push(B[i]);
  }

  if (leftover > 0) {
    scores.push(leftover);
  }
}

scores.sort((a, b) => b - a);

let sum = A.reduce((acc, cur) => acc + cur, 0);

for (let i = 0; i < Math.min(N, scores.length); i++) {
  sum += scores[i];
}

console.log(sum);
