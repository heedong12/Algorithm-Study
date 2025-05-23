let dx = [0, 0, -1, 1];
let dy = [-1, 1, 0, 0];
const dfs = (x, y, m, n, map, visited) => {
  visited[y][x] = true;
  for (let i = 0; i < 4; i++) {
    let nx = dx[i] + x;
    let ny = dy[i] + y;

    if (
      nx >= 0 &&
      nx < m &&
      ny >= 0 &&
      ny < n &&
      !visited[ny][nx] &&
      map[ny][nx] === 1
    ) {
      dfs(nx, ny, m, n, map, visited);
    }
  }
};

let [T, ...infos] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let answer = [];

for (let i = 0; i < +T; i++) {
  let [M, N, K] = infos.shift().split(" ").map(Number);
  let mapsInfo = infos.splice(0, K);
  // 1이 지렁이 있음
  let maps = Array.from({ length: N }, () => new Array(M).fill(0));
  let visited = Array.from({ length: N }, () => new Array(M).fill(false));
  for (let j = 0; j < mapsInfo.length; j++) {
    let [x, y] = mapsInfo[j].split(" ").map(Number);
    maps[y][x] = 1;
  }

  let count = 0;
  for (let j = 0; j < maps.length; j++) {
    for (let k = 0; k < maps[0].length; k++) {
      if (maps[j][k] === 1 && !visited[j][k]) {
        dfs(k, j, M, N, maps, visited);
        count++;
      }
    }
  }
  answer.push(count);
}

console.log(answer.join("\n"));
