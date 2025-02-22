let [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

inputs = inputs
  .map((item) => item.split(" ").map(Number))
  .sort((a, b) => (a[1] === b[1] ? a[0] - b[0] : a[1] - b[1]));

let count = 0;
let end = 0;

inputs.forEach((item) => {
  if (end <= item[0]) {
    end = item[1];
    count++;
  }
});
console.log(count);
