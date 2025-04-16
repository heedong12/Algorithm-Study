let [NM, ...nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = NM.split(" ").map(Number);
const standard = [];
for (let i = 0; i < N; i++) {
  let [grade, score] = nums[i].split(" ");
  standard.push([grade, Number(score)]);
}
standard.sort((a, b) => a[1] > b[1]);
let answers = [];

for (let j = N; j < nums.length; j++) {
  let findGrade = Number(nums[j]);
  let start = 0;
  let end = N - 1;
  let mid = 0;

  while (start <= end) {
    mid = Math.floor((start + end) / 2);

    if (findGrade <= standard[mid][1]) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  start < N
    ? answers.push(standard[start][0])
    : answers.push(standard[N - 1][0]);
}
console.log(answers.join("\n"));
