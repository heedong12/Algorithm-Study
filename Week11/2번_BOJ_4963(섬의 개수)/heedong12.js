let inputs = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const directions = [
  [-1, -1],
  [-1, 0],
  [-1, 1],
  [0, -1],
  [0, 1],
  [1, -1],
  [1, 0],
  [1, 1],
];

const BFS = (x, y, visited, map, w, h) => {
  let queue = [[x, y]];
  visited[y][x] = true;

  while (queue.length > 0) {
    let [cx, cy] = queue.shift();

    for (let i = 0; i < directions.length; i++) {
      let nx = cx + directions[i][0];
      let ny = cy + directions[i][1];

      if (
        nx >= 0 &&
        nx < w &&
        ny >= 0 &&
        ny < h &&
        !visited[ny][nx] &&
        map[ny][nx] === 1
      ) {
        queue.push([nx, ny]);
        visited[ny][nx] = true;
      }
    }
  }
};

let idx = 0;
let answers = [];
while (true) {
  let [w, h] = inputs[idx++].split(" ").map(Number);
  if (w === 0 && h === 0) break;

  let map = [];
  for (let i = 0; i < h; i++) {
    map.push(inputs[idx++].split(" ").map(Number));
  }
  let visited = Array.from({ length: h }, () => new Array(w).fill(false));
  let result = 0;

  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      if (!visited[i][j] && map[i][j] === 1) {
        BFS(j, i, visited, map, w, h);
        result++;
      }
    }
  }
  answers.push(result);
}

console.log(answers.join("\n"));
