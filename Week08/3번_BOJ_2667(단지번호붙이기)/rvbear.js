let [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let map = input.map((line) => line.trim().split("").map((c) => Number(c)));
let visit = Array.from(Array(n), () => Array(n).fill(false));
let temp = 0;

let dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const dfs = (x, y) => {
  visit[x][y] = true;

  for (let i = 0; i < 4; i++) {
    let nx = x + dir[i][0];
    let ny = y + dir[i][1];

    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny] === 1) {
      temp++;
      dfs(nx, ny);
    }
  }
};

let ans = [];

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (!visit[i][j] && map[i][j] === 1) {
      temp = 1;
      dfs(i, j);
      ans.push(temp);
    }
  }
}

ans.sort((a, b) => a - b);

console.log(ans.length);
console.log(ans.join("\n"));
