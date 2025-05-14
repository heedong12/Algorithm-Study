// 1392ms
let [string, bomb] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let stack = [];
let n = bomb.length;

for (let s of string) {
  stack.push(s);

  if (stack.length >= n && stack.slice(-n).join("") === bomb) {
    stack.splice(-n);
  }
}
console.log(stack.length > 0 ? stack.join("") : "FRULA");

// 324ms
let [string, bomb] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let stack = [];
let n = bomb.length;
let lastChar = bomb[bomb.length - 1];

for (let s of string) {
  stack.push(s);

  if (s === lastChar && stack.length >= n) {
    let flag = true;
    for (let i = 0; i < n; i++) {
      if (stack[stack.length - n + i] !== bomb[i]) {
        flag = false;
        break;
      }
    }

    if (flag) {
      for (let i = 0; i < n; i++) {
        stack.pop();
      }
    }
  }
}
console.log(stack.length > 0 ? stack.join("") : "FRULA");
