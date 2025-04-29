const [SP, DNA, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [S, P] = SP.split(" ").map(Number);
const checkArr = nums.split(" ").map(Number);
const currentCount = [0, 0, 0, 0];

const add = (c) => {
  if (c === "A") currentCount[0]++;
  else if (c === "C") currentCount[1]++;
  else if (c === "G") currentCount[2]++;
  else if (c === "T") currentCount[3]++;
};

const remove = (c) => {
  if (c === "A") currentCount[0]--;
  else if (c === "C") currentCount[1]--;
  else if (c === "G") currentCount[2]--;
  else if (c === "T") currentCount[3]--;
};

const isValid = () => {
  for (let i = 0; i < 4; i++) {
    if (currentCount[i] < checkArr[i]) return false;
  }
  return true;
};

let result = 0;
for (let i = 0; i < P; i++) {
  add(DNA[i]);
}
if (isValid()) result++;

for (let i = P; i < S; i++) {
  add(DNA[i]);
  remove(DNA[i - P]);
  if (isValid()) result++;
}

console.log(result);
