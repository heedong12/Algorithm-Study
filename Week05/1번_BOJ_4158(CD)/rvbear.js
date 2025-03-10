const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
let ans = [];

while (idx < input.length - 1) {
  const [n, m] = input[idx++].split(" ").map(Number);
  let nIdx = idx;
  let mIdx = idx + n;
  let cnt = 0;

  while (nIdx < n + idx && mIdx < n + m + idx) {
    if (Number(input[nIdx]) < Number(input[mIdx])) {
      nIdx++;
    } else if (Number(input[nIdx]) > Number(input[mIdx])) {
      mIdx++;
    } else {
      cnt++;
      nIdx++;
      mIdx++;
    }
  }

  ans.push(cnt);
  idx += n + m;
}

console.log(ans.join("\n"));
