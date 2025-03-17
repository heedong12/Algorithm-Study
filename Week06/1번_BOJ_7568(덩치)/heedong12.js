let [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

inputs = inputs.map((item) => item.split(" ").map(Number));

const answer = [];

for (let i = 0; i < N; i++) {
  let count = 1;
  for (let j = 0; j < N; j++) {
    if (i === j) continue;
    if (inputs[j][0] > inputs[i][0] && inputs[j][1] > inputs[i][1]) count++;
  }
  answer.push(count);
}

console.log(answer.join(" "));
