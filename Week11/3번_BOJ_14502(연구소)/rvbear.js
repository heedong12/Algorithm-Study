let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, m] = input[0].split(" ").map(Number);
let map = [], temp = [];

for (let i = 1; i < n + 1; i++) {
  map.push(input[i].split(" ").map(Number));
  temp.push(new Array(m).fill(0));
}

let dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];
let max = 0;

const spread = (x, y) => {
  for (let i = 0; i < 4; i++) {
    let nx = x + dir[i][0];
    let ny = y + dir[i][1];

    if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) {
      continue;
    }

    if (temp[nx][ny] === 0) {
      temp[nx][ny] = 2;
      spread(nx, ny);
    }
  }
};

const getCount = () => {
  let cnt = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (temp[i][j] === 0) {
        cnt += 1;
      }
    }
  }

  return cnt;
};

const dfs = (x, y, depth) => {
  if (depth === 3) {
    temp = map.map(row => row.slice());

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < m; j++) {
        if (temp[i][j] === 2) {
          spread(i, j);
        }
      }
    }

    max = Math.max(max, getCount());
    return;
  }

  for (let i = x; i < n; i++) {
    for (let j = i === x ? y : 0; j < m; j++) {
      if (map[i][j] === 0) {
        map[i][j] = 1;
        dfs(i, j + 1, depth + 1);
        map[i][j] = 0;
      }
    }
  }
};

dfs(0, 0, 0);

console.log(max);
