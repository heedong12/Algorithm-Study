let [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
let map = input.map((v) => v.split(" ").map(Number));
let set = new Set(map.flat());
let visit;
let dir = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const dfs = (x, y, num) => {
  visit[x][y] = true;

  for (let i = 0; i < 4; i++) {
    let nx = x + dir[i][0];
    let ny = y + dir[i][1];

    if (
      nx >= 0 &&
      nx < n &&
      ny >= 0 &&
      ny < n &&
      !visit[nx][ny] &&
      map[nx][ny] >= num
    ) {
      dfs(nx, ny, num);
    }
  }
};

let max = 0;

for (let num of set) {
  visit = Array.from(Array(n), () => Array(n).fill(false));
  let cnt = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (!visit[i][j] && map[i][j] >= num) {
        dfs(i, j, num);
        cnt++;
      }
    }
  }

  max = Math.max(max, cnt);
}

console.log(max);
