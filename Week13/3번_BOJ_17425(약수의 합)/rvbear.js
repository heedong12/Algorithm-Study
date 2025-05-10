let [t, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let n = Array(1000001).fill(0);

for (let i = 1; i < n.length; i++) {
  for (let j = i; j < n.length; j += i) {
    n[j] += i;
  }
}

for (let i = 2; i < n.length; i++) {
  n[i] += n[i - 1];
}

let res = [];
for (let i = 0; i < +t; i++) {
  res.push(n[+input[i]]);
}

console.log(res.join("\n"));
