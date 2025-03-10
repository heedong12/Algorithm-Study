const inputs = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
while (idx < inputs.length) {
  let [N, M] = inputs[idx++].split(" ").map(Number);
  if ((N === 0) & (M === 0)) break;
  let sangIdx = idx;
  let sunIdx = idx + N;
  let count = 0;

  while (sangIdx < N + idx && sunIdx < N + M + idx) {
    if (Number(inputs[sangIdx]) < Number(inputs[sunIdx])) sangIdx++;
    else if (Number(inputs[sangIdx]) > Number(inputs[sunIdx])) sunIdx++;
    else if (Number(inputs[sangIdx]) === Number(inputs[sunIdx])) {
      count++;
      sangIdx++;
      sunIdx++;
    }
  }
  idx = idx + N + M;
  console.log(count);
}
