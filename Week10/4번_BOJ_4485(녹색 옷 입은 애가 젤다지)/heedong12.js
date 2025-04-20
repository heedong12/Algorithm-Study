const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const directions = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

let idx = 0;
let testCase = 1;

while (true) {
  const N = Number(input[idx++]);
  if (N === 0) break;

  const map = [];
  for (let i = 0; i < N; i++) {
    map.push(input[idx++].split(" ").map(Number));
  }

  const dist = Array.from({ length: N }, () => Array(N).fill(Infinity));
  dist[0][0] = map[0][0];

  const pq = [[map[0][0], 0, 0]];

  while (pq.length > 0) {
    pq.sort((a, b) => a[0] - b[0]);
    const [cost, y, x] = pq.shift();

    if (dist[y][x] < cost) continue;

    for (let i = 0; i < 4; i++) {
      const ny = y + directions[i][0];
      const nx = x + directions[i][1];

      if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
        const newCost = cost + map[ny][nx];
        if (newCost < dist[ny][nx]) {
          dist[ny][nx] = newCost;
          pq.push([newCost, ny, nx]);
        }
      }
    }
  }

  console.log(`Problem ${testCase++}: ${dist[N - 1][N - 1]}`);
}
