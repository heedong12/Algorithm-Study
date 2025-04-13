let [_, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
nums = nums.split(" ").map(Number).reverse();
const answers = [];
const stack = [];
nums.forEach((item) => {
  while (stack.length > 0) {
    let prev = stack.pop();
    if (prev > item) {
      stack.push(prev);
      stack.push(item);
      answers.push(prev);
      break;
    }
  }
  if (stack.length === 0) {
    answers.push(-1);
    stack.push(item);
  }
});

console.log(answers.reverse().join(" "));
