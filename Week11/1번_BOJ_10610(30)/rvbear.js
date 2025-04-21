let n = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("")
  .map(Number);

let sum = n.reduce((a, b) => a + b);
console.log(n.includes(0) && sum % 3 === 0 ? n.sort((a, b) => b - a).join("") : -1);
