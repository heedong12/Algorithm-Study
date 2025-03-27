let [n, input, x] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let numList = input.split(" ").map(Number);
x = Number(x);
let set = new Set(numList);

let cnt = 0;

for (let v of numList) {
  let target = x - v;

  if (set.has(target) && v < target) {
    cnt++;
  }
}

console.log(cnt);
