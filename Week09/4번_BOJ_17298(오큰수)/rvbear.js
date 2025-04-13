let [n, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let a = input.split(" ").map(Number);
let stack = [];

for (let i = 0; i < n; i++) {
  while (stack.length !== 0 && a[i] > a[stack[stack.length - 1]]) {
    a[stack.pop()] = a[i];
  }

  stack.push(i);
}

while (stack.length !== 0) {
  a[stack.pop()] = -1;
}

console.log(a.join(" "));
