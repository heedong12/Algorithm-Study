let [Ndkc, ...sushis] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, d, k, c] = Ndkc.split(" ").map(Number);
sushis = sushis.map(Number);

let check = new Array(d + 1).fill(0);
let cnt = 0;

for (let i = 0; i < k; i++) {
  if (check[sushis[i]] === 0) cnt++;
  check[sushis[i]] += 1;
}

if (check[c] === 0) cnt++;
check[c]++;
let max = cnt;

for (let i = 0; i < N; i++) {
  let startTarget = sushis[i % N];
  check[startTarget]--;
  if (check[startTarget] === 0) cnt--;

  let endTarget = sushis[(i + k) % N];
  if (check[endTarget] === 0) cnt++;
  check[endTarget]++;

  max = Math.max(max, cnt);
}

console.log(max);
