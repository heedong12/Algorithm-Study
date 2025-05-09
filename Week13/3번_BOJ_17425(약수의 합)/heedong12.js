let [N, ...nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const max = Math.max(...nums);

let fArr = Array.from({ length: max + 1 }, (_, i) => 0);

// fArr은 약수들의 합을 저장
for (let i = 1; i <= max; i++) {
  for (let j = i; j <= max; j += i) {
    fArr[j] += i;
  }
}

// sArr에는 이전 합들과 i번째 약수의 합을 더함
let sArr = Array.from({ length: max + 1 }, (_, i) => 0);
for (let i = 1; i <= max; i++) {
  sArr[i] = sArr[i - 1] + fArr[i];
}

let answer = nums.map((item) => sArr[item]);
console.log(answer.join("\n"));
