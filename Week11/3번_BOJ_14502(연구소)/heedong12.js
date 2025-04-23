let [NM, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, M] = NM.split(" ").map(Number);
maps = maps.map((item) => item.split(" ").map(Number));

let max = 0;
const directions = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const BFS = (x, y, arr) => {
  let queue = [[x, y]];

  while (queue.length > 0) {
    let [cx, cy] = queue.shift();

    for (let d of directions) {
      let [nx, ny] = [cx + d[0], cy + d[1]];
      if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] === 0) {
        arr[nx][ny] = 2;
        queue.push([nx, ny]);
      }
    }
  }
};

const DFS = (count) => {
  if (count === 3) {
    let arr = maps.map((item) => [...item]);

    // 바이러스 확산
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (arr[i][j] === 2) {
          BFS(i, j, arr);
        }
      }
    }
    // 안전한 영역 세기
    let total = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (arr[i][j] === 0) total++;
      }
    }

    return (max = Math.max(max, total));
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (maps[i][j] === 0) {
        maps[i][j] = 1;
        DFS(count + 1);
        maps[i][j] = 0;
      }
    }
  }
};

DFS(0);
console.log(max);
