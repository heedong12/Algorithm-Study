let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, m] = input[0].split(" ").map(Number);
let map = Array.from({ length: n }, () => []);
let root = Array.from({ length: n }).fill(0);

for (let i = 0; i < m; i++) {
  let [start, end] = input[i + 1]
    .split(" ")
    .map((v) => v.charCodeAt(0) - "A".charCodeAt(0));
  map[start].push(end);
  root[end]++;
}

let cnt = 0;
let visit = Array.from({ length: n }).fill(false);

let [num, ...targetList] = input[m + 1].split(" ");
num = +num;
targetList = targetList.map((v) => v.charCodeAt(0) - "A".charCodeAt(0));

for (let target of targetList) {
  visit[target] = true;
}

const dfs = (start) => {
  if (!visit[start]) {
    let list = map[start];

    for (let t of list) {
      if (!visit[t]) {
        cnt++;
        dfs(t);
      }
    }
  }
};

for (let i = 0; i < n; i++) {
  if (root[i] === 0) {
    dfs(i);
  }
}

console.log(cnt);
