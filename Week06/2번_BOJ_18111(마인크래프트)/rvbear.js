const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m, b] = input.shift().split(" ").map(Number);
let heights = Array.from({ length: 257 }).fill(0);
let mapSize = n * m;
let blocks = 0;
let minHeight = Number.MAX_SAFE_INTEGER;

input.map((arr) =>
  arr.split(" ").map((h) => {
    heights[Number(h)]++;
    blocks += Number(h);
    minHeight = Math.min(Number(h), minHeight);
  })
);

let maxHeight =
  b + blocks < mapSize * 256 ? Math.floor((b + blocks) / mapSize) : 256;
let t = (blocks - minHeight * mapSize) * 2;

let time = t;
let height = minHeight;
blocks = 0;

for (let i = minHeight + 1; i <= maxHeight; i++) {
  blocks += heights[i - 1];
  t += blocks - (mapSize - blocks) * 2;

  if (time >= t) {
    time = t;
    height = i;
  }
}

console.log(time, height);
