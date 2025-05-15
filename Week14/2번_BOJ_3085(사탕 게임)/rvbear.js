// ver 1
let [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = +n;
let map = input.map((line) => line.trim().split(""));
let max = 0;

const swap = (x1, y1, x2, y2) => {
  [map[x1][y1], map[x2][y2]] = [map[x2][y2], map[x1][y1]];
};

const check = () => {
  for (let i = 0; i < n; i++) {
    let rowCnt = 1,
      colCnt = 1;

    for (let j = 0; j < n - 1; j++) {
      if (map[i][j] === map[i][j + 1]) {
        rowCnt++;
      } else {
        rowCnt = 1;
      }

      if (map[j][i] === map[j + 1][i]) {
        colCnt++;
      } else {
        colCnt = 1;
      }

      max = Math.max(rowCnt, colCnt, max);
    }
  }
};

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n - 1; j++) {
    if (map[i][j] !== map[i][j + 1]) {
      swap(i, j, i, j + 1);
      check();
      swap(i, j, i, j + 1);
    }

    if (map[j][i] !== map[j + 1][i]) {
      swap(j + 1, i, j, i);
      check();
      swap(j + 1, i, j, i);
    }
  }
}

console.log(max);

// ver 2
let [n, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = +n;
let map = input.map((line) => line.trim().split(""));
let max = 1;

const swap = (x1, y1, x2, y2) => {
  [map[x1][y1], map[x2][y2]] = [map[x2][y2], map[x1][y1]];
};

const check = (row, col) => {
  let rowCnt = 1;
  let colCnt = 1;
  const target = map[row][col];

  for (let i = row - 1; i >= 0; i--) {
    if (target === map[i][col]) {
      rowCnt++;
    } else {
      break;
    }
  }

  for (let i = row + 1; i < n; i++) {
    if (target === map[i][col]) {
      rowCnt++;
    } else {
      break;
    }
  }

  for (let i = col - 1; i >= 0; i--) {
    if (target === map[row][i]) {
      colCnt++;
    } else {
      break;
    }
  }

  for (let i = col + 1; i < n; i++) {
    if (target === map[row][i]) {
      colCnt++;
    } else {
      break;
    }
  }

  max = Math.max(max, rowCnt, colCnt);
};

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n - 1; j++) {
    swap(i, j, i, j + 1);
    check(i, j);
    check(i, j + 1);
    swap(i, j, i, j + 1);

    swap(j + 1, i, j, i);
    check(j, i);
    check(j + 1, i);
    swap(j + 1, i, j, i);
  }
}

console.log(max);
