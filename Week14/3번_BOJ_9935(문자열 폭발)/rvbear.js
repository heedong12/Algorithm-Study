let [line, remove] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let boom = remove.split("");
let boomLen = boom.length;
let stack = [];

for (let i = 0; i < line.length; i++) {
  stack.push(line[i]);

  if (stack.length >= boomLen && stack.slice(-boomLen).join("") === remove) {
    stack.length -= boomLen;
  }
}

console.log(stack.length === 0 ? "FRULA" : stack.join(""));
