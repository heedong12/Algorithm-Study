let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let dir = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]];

let idx = 0,
  res = [];

while (true) {
  let [w, h] = input[idx++].split(" ").map(Number);
  if (w === 0 && h === 0) break;

  let map = input.slice(idx, idx + h).map((line) => line.split(" ").map(Number));
  idx += h;

  let visited = Array.from({ length: h }, () => Array(w).fill(false));
  let count = 0;

  const bfs = (x, y) => {
    let q = [[x, y]];
    visited[y][x] = true;
    
    while (q.length) {
      let [cx, cy] = q.shift();
      for (let [dx, dy] of dir) {
        let [nx, ny] = [cx + dx, cy + dy];
        if (nx >= 0 && ny >= 0 && nx < w && ny < h && !visited[ny][nx] && map[ny][nx]) {
          visited[ny][nx] = true;
          q.push([nx, ny]);
        }
      }
    }
  };

  for (let y = 0; y < h; y++) {
    for (let x = 0; x < w; x++) {
      if (!visited[y][x] && map[y][x]) {
        bfs(x, y); 
        count++;
      }
    }
  }

  res.push(count);
}

console.log(res.join("\n"));
