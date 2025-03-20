const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input.shift());
const map = input.map((v) => v.split(" ").map(Number));

let visit = Array(n).fill(false);
let min = Infinity;

function dfs(cur, cost, depth) {
  if (depth === n - 1) {
    if (map[cur][0] !== 0) {
      min = Math.min(min, cost + map[cur][0]);
    }
    return;
  }

  for (let i = 0; i < n; i++) {
    if (!visit[i] && map[cur][i] !== 0) {
      if (cost + map[cur][i] < min) {
        visit[i] = true;
        dfs(i, cost + map[cur][i], depth + 1);
        visit[i] = false;
      }
    }
  }
}

visit[0] = true;
dfs(0, 0, 0);
console.log(min);
