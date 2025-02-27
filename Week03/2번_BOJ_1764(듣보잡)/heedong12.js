const [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const answer = [];
const set = new Set();

inputs.forEach((item) => {
  set.has(item) ? answer.push(item) : set.add(item);
});
console.log(answer.length + "\n" + answer.sort().join("\n"));
