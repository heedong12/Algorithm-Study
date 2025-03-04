let [M, colorNums, K] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

colorNums = colorNums.split(" ").map(Number);
const sum = colorNums.reduce((acc, cur) => {
  return (acc += cur);
}, 0);

const combination = (total, pick) => {
  if (Math.floor(total / 2) < pick) pick = total - pick;

  let answer = 1;
  for (let i = 0; i < pick; i++) {
    answer = (answer * (total - i)) / (pick - i);
  }
  return answer;
};

let mol = colorNums.reduce((acc, cur) => {
  if (cur >= K) {
    return (acc += combination(cur, K));
  } else return (acc += 0);
}, 0);

let den = combination(sum, K);

console.log((mol / den) % 1 === 0 ? `${mol / den}.0` : mol / den);
