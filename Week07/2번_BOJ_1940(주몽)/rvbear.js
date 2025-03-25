let [n, m, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
m = Number(m);
const numList = input.split(" ").map(Number);
const visit = new Set(numList);

let cnt = 0;

for (let v of numList) {
  let target = m - v;

  if (visit.has(target) && -1 < target && target < 100001) {
    cnt++;
  }
}

console.log(Math.floor(cnt / 2));
