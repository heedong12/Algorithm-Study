let [NMK, ...infos] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

// 행, 열
const Directions = [
  [-1, 0],
  [-1, 1],
  [0, 1],
  [1, 1],
  [1, 0],
  [1, -1],
  [0, -1],
  [-1, -1],
];
const [N, _, K] = NMK.split(" ").map(Number);
let maps = new Map();

// 좌표 계산
const calcRC = (r, c, s, d) => {
  let [nr, nc] = [r + Directions[d][0] * s, c + Directions[d][1] * s];
  nr = ((nr % N) + N) % N;
  nc = ((nc % N) + N) % N;

  return [nr, nc];
};

for (let info of infos) {
  let [r, c, m, s, d] = info.split(" ").map(Number);
  maps.set(`${r - 1},${c - 1}`, [[m, s, d]]);
}

for (let i = 0; i < K; i++) {
  let newMap = new Map();

  // 파이어볼 이동
  maps.forEach((value, key) => {
    let [r, c] = key.split(",").map(Number);

    value.map((item) => {
      let [m, s, d] = item;
      let [nr, nc] = calcRC(r, c, s, d);
      if (!newMap.has(`${nr},${nc}`)) {
        newMap.set(`${nr},${nc}`, [[m, s, d]]);
      } else {
        newMap.get(`${nr},${nc}`).push([m, s, d]);
      }
    });
  });

  maps.clear();

  // 파이어 볼 이동 후 처리
  newMap.forEach((value, key) => {
    // 2개 이상의 파이어볼이 존재
    if (value.length > 1) {
      let totalM = 0;
      let totalS = 0;
      let isEven = true;
      let isOdd = true;

      for (let v of value) {
        let m = v[0];
        let s = v[1];
        let d = v[2];

        totalM += m;
        totalS += s;
        if (d % 2 != 0) {
          isEven = false;
        } else {
          isOdd = false;
        }
      }
      totalM = Math.floor(totalM / 5);
      totalS = Math.floor(totalS / value.length);

      if (totalM === 0) return;
      let startDir = isEven || isOdd ? 0 : 1;

      for (let j = startDir; j < 8; j += 2) {
        if (!maps.has(key)) {
          maps.set(key, [[totalM, totalS, j]]);
        } else {
          maps.get(key).push([totalM, totalS, j]);
        }
      }
    } else {
      maps.set(key, value);
    }
  });
}

let answer = 0;

maps.forEach((map, key) => {
  map.forEach((item) => {
    answer += item[0];
  });
});

console.log(answer);
