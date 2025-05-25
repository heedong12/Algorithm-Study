let [N, ...infos] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let K = infos.shift();
let maps = Array.from({ length: +N }, () => new Array(+N).fill(0));
// 우 하 좌 상
let dx = [0, 1, 0, -1];
let dy = [1, 0, -1, 0];

for (let i = 0; i < +K; i++) {
  let [y, x] = infos.shift().split(" ").map(Number);
  maps[y - 1][x - 1] = 1;
}

let L = infos.shift();
let bamInfo = [];
for (let i = 0; i < +L; i++) {
  let [time, dir] = infos.shift().split(" ");
  bamInfo.push([+time, dir]);
}

let dir = 0;
let time = 0;
let bam = [[0, 0]];
maps[0][0] = 2;

while (true) {
  time++;

  let [cx, cy] = bam[bam.length - 1];
  let nx = cx + dx[dir];
  let ny = cy + dy[dir];

  if (nx < 0 || nx >= +N || ny < 0 || ny >= +N || maps[nx][ny] === 2) break;

  if (maps[nx][ny] === 1) {
    maps[nx][ny] = 2;
    bam.push([nx, ny]);
  } else {
    maps[nx][ny] = 2;
    bam.push([nx, ny]);
    let [tx, ty] = bam.shift();
    maps[tx][ty] = 0;
  }

  if (bamInfo.length && time === bamInfo[0][0]) {
    let [_, c] = bamInfo.shift();
    dir = c === "D" ? (dir + 1) % 4 : (dir + 3) % 4;
  }
}

console.log(time);
