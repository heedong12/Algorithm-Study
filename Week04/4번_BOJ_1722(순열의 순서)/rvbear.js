const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let n = Number(input.shift());
let [q, ...arr] = input.shift().split(" ").map(BigInt);

const factorial = Array(n + 1).fill(BigInt(1));
for (let i = 1; i <= n; i++) {
  factorial[i] = factorial[i - 1] * BigInt(i);
}

if (q === BigInt(1)) {
  let k = BigInt(arr[0]);
  const ans = [];
  const available = new Set(Array.from({ length: n }, (_, i) => i + 1));

  for (let i = 0; i < n; i++) {
    for (let num of available) {
      if (factorial[n - i - 1] < k) {
        k -= factorial[n - i - 1];
      } else {
        ans.push(num);
        available.delete(num);
        break;
      }
    }
  }
  console.log(ans.join(" "));
} else {
  let ans = 1n;
  const visit = new Set();

  for (let i = 0; i < n; i++) {
    for (let j = 1; j < Number(arr[i]); j++) {
      if (!visit.has(j)) {
        ans += factorial[n - i - 1];
      }
    }
    visit.add(Number(arr[i]));
  }
  console.log(ans.toString());
}
