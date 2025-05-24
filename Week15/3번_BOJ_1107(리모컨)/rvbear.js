let [n, m, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
m = Number(m);
let check = Array(10).fill(false);
if (m > 0) {
  input.split(" ").forEach((v) => (check[+v] = true));
}

let ans = Math.abs(100 - n);

const dfs = (num, depth) => {
  if (depth === 6) {
    return;
  }

  num *= 10;
  for (let i = 0; i < 10; i++) {
    if (!check[i]) {
      ans = Math.min(ans, Math.abs(n - (num + i)) + depth + 1);
      dfs(num + i, depth + 1);
    }
  }
};

dfs(0, 0);
console.log(ans);
