let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
let parent;
let res = [];

const find = (x) => {
  if (x === parent[x]) {
    return x;
  }

  return (parent[x] = find(parent[x]));
};

const union = (x, y) => {
  x = find(x);
  y = find(y);

  if (x !== y) {
    parent[y] = x;
  }
};

while (true) {
  let [m, n] = input[idx++].split(" ").map(Number);

  if (m === 0 && n === 0) {
    break;
  }

  let edgeList = [];
  let totalCost = 0;
  for (let i = 0; i < n; i++) {
    let [x, y, z] = input[idx++].split(" ").map(Number);

    edgeList.push([x, y, z]);
    totalCost += z;
  }

  edgeList.sort((o1, o2) => o1[2] - o2[2]);

  parent = [];
  for (let i = 0; i < n; i++) {
    parent[i] = i;
  }

  let minCost = 0;
  for (let i = 0; i < edgeList.length; i++) {
    let [start, end, cost] = edgeList[i];

    if (find(start) !== find(end)) {
      minCost += cost;
      union(start, end);
    }
  }

  res.push(totalCost - minCost);
}

console.log(res.join("\n"));
