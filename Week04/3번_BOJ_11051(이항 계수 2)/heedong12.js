const [N, K] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const combination = (total, pick) => {
  if (Math.floor(total / 2) < pick) pick = total - pick;

  let answer = 1n;
  for (let i = 0; i < pick; i++) {
    answer = (answer * BigInt(total - i)) / BigInt(i + 1);
  }
  return answer % 10007n;
};

console.log(combination(N, K).toString());
