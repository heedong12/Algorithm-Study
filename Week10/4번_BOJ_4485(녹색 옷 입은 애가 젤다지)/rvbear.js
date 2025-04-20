let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let t = 1;
let res = [];
let dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const bfs = (map, n) => {
  let q = [[0, 0]];
  let cost = Array.from(new Array(n), () => new Array(n).fill(Infinity));
  cost[0][0] = map[0][0];

  while (q.length) {
    let [x, y] = q.shift();

    for (let i = 0; i < 4; i++) {
      let nx = x + dir[i][0];
      let ny = y + dir[i][1];

      if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) {
        continue;
      }

      let temp = cost[x][y] + map[nx][ny];
      if (cost[nx][ny] > temp) {
        cost[nx][ny] = temp;
        q.push([nx, ny]);
      }
    }
  }

  return cost[n - 1][n - 1];
};

while (true) {
  let n = +input.shift();

  if (n === 0) {
    break;
  }

  let map = input.splice(0, n).map((line) => line.split(" ").map(Number));

  res.push(`Problem ${t++}: ${bfs(map, n)}`);
}

console.log(res.join("\n"));
