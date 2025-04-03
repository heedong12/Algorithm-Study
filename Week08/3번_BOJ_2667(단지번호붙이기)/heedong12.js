let [N, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
maps = maps.map((map) => map.split("").map(Number));

// 상하좌우
const dir = [
  [0, -1],
  [0, 1],
  [-1, 0],
  [1, 0],
];

const dfs = (x, y) => {
  const queue = [[x, y]];
  isVisited[y][x] = true;
  let count = 1;

  while (queue.length > 0) {
    let [dx, dy] = queue.shift();

    for (let d of dir) {
      let nx = dx + d[0];
      let ny = dy + d[1];

      if (
        nx >= 0 &&
        nx < N &&
        ny >= 0 &&
        ny < N &&
        !isVisited[ny][nx] &&
        maps[ny][nx] === 1
      ) {
        queue.push([nx, ny]);
        isVisited[ny][nx] = true;
        count++;
      }
    }
  }

  return count;
};

let answers = [];
let isVisited = Array.from({ length: N }, () => new Array(N).fill(false));

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (!isVisited[j][i] && maps[j][i] === 1) {
      let c = dfs(i, j);
      answers.push(c);
    }
  }
}

console.log(answers.length);
console.log(answers.sort((a, b) => a - b).join("\n"));
