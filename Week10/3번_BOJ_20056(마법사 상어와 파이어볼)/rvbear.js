let [NMK, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, M, K] = NMK.split(" ").map(Number);
let map = Array.from({ length: N }, () => Array.from({ length: N }, () => []));

let fireballs = [];
for (let i = 0; i < M; i++) {
  let [r, c, m, s, d] = input[i].split(" ").map(Number);
  fireballs.push([r - 1, c - 1, m, s, d]);
}

let pair = [
  [-1, 0],
  [-1, 1],
  [0, 1],
  [1, 1],
  [1, 0],
  [1, -1],
  [0, -1],
  [-1, -1],
];

while (K-- > 0) {
  while (fireballs.length > 0) {
    let [r, c, m, s, d] = fireballs.pop();
    let nr = (r + (N + pair[d][0]) * s) % N;
    let nc = (c + (N + pair[d][1]) * s) % N;
    map[nr][nc].push([m, s, d]);
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j].length > 1) {
        let [mSum, sSum, cnt, odd, even] = [0, 0, map[i][j].length, 0, 0];

        while (map[i][j].length > 0) {
          let [m, s, d] = map[i][j].pop();
          mSum += m;
          sSum += s;

          if (d % 2 == 0) {
            odd++;
          } else {
            even++;
          }
        }

        mSum = Math.floor(mSum / 5);
        sSum = Math.floor(sSum / cnt);
        let newD = odd === cnt || even === cnt ? [0, 2, 4, 6] : [1, 3, 5, 7];

        if (mSum > 0) {
          for (let d of newD) {
            fireballs.push([i, j, mSum, sSum, d]);
          }
        }
      } else if (map[i][j].length === 1) {
        fireballs.push([i, j, ...map[i][j].pop()]);
      }
    }
  }
}

let res = fireballs.reduce((acc, [r, c, m, s, d]) => acc + m, 0);
console.log(res);
