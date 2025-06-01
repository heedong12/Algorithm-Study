let [NM, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let [N, M] = NM.split(" ").map(Number);
maps = maps.map((map) => map.split(" ").map(Number));

const dir = [
  // 민트
  [
    [0, 1, 2, 3],
    [0, 0, 0, 0],
  ],
  [
    [0, 0, 0, 0],
    [0, 1, 2, 3],
  ],
  // 노랑
  [
    [0, 0, 1, 1],
    [0, 1, 0, 1],
  ],
  // 주황
  [
    [0, 1, 0, 0],
    [0, 0, 1, 2],
  ],
  [
    [0, 0, 1, 2],
    [0, 1, 1, 1],
  ],
  [
    [0, 0, 0, -1],
    [0, 1, 2, 2],
  ],
  [
    [0, 1, 2, 2],
    [0, 0, 0, 1],
  ],

  // 대칭 주황
  [
    [0, 0, -1, -2],
    [0, 1, 1, 1],
  ],
  [
    [0, 1, 1, 1],
    [0, 0, 1, 2],
  ],
  [
    [0, 1, 2, 0],
    [0, 0, 0, 1],
  ],
  [
    [0, 0, 0, 1],
    [0, 1, 2, 2],
  ],

  // 초록
  [
    [0, 1, 1, 2],
    [0, 0, 1, 1],
  ],
  [
    [0, 0, -1, -1],
    [0, 1, 1, 2],
  ],

  // 대칭초록
  [
    [0, 1, 0, -1],
    [0, 0, 1, 1],
  ],
  [
    [0, 0, 1, 1],
    [0, 1, 1, 2],
  ],

  // 핑크
  [
    [0, 0, 1, 0],
    [0, 1, 1, 2],
  ],
  [
    [0, 1, 2, 1],
    [0, 0, 0, 1],
  ],
  [
    [0, -1, 0, 1],
    [0, 1, 1, 1],
  ],
  [
    [0, 0, 0, -1],
    [0, 1, 2, 1],
  ],
];

let dfs = (x, y, dx, dy) => {
  let sum = 0;
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];

    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
      sum += maps[nx][ny];
    }
  }
  return sum;
};

let max = 0;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    for (let [dx, dy] of dir) {
      let score = dfs(i, j, dx, dy);
      if (score > max) max = score;
    }
  }
}

console.log(max);
