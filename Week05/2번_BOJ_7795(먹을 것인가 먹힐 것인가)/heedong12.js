const [T, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const answer = [];
for (let i = 0; i < inputs.length; i = i + 3) {
  let [N, M] = inputs[i].split(" ").map(Number);
  let A = inputs[i + 1].split(" ").map(Number);
  let B = inputs[i + 2]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);

  let count = 0;
  A.forEach((item) => {
    let start = 0;
    let end = M - 1;

    while (start <= end) {
      let mid = Math.floor((start + end) / 2);
      if (B[mid] < item) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    count += start;
  });
  answer.push(count);
}

console.log(answer.join("\n"));
