let [N, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
maps = maps.map((m) => m.split(""));

const getMaxCandies = () => {
  let max = 1;

  for (let i = 0; i < N; i++) {
    let count = 1;
    for (let j = 1; j < N; j++) {
      if (maps[i][j] === maps[i][j - 1]) {
        count++;
        max = Math.max(max, count);
      } else {
        count = 1;
      }
    }
  }

  for (let j = 0; j < N; j++) {
    let count = 1;
    for (let i = 1; i < N; i++) {
      if (maps[i][j] === maps[i - 1][j]) {
        count++;
        max = Math.max(max, count);
      } else {
        count = 1;
      }
    }
  }

  return max;
};

let answer = 0;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (i + 1 < N && maps[i][j] !== maps[i + 1][j]) {
      [maps[i][j], maps[i + 1][j]] = [maps[i + 1][j], maps[i][j]];
      answer = Math.max(answer, getMaxCandies());
      [maps[i][j], maps[i + 1][j]] = [maps[i + 1][j], maps[i][j]];
    }

    if (j + 1 < N && maps[i][j] !== maps[i][j + 1]) {
      [maps[i][j], maps[i][j + 1]] = [maps[i][j + 1], maps[i][j]];
      answer = Math.max(answer, getMaxCandies());
      [maps[i][j], maps[i][j + 1]] = [maps[i][j + 1], maps[i][j]];
    }
  }
}

console.log(answer);
