const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
let m, n;
const edges = [];
let parent;

const findParent = (node) => {
  if (parent[node] === node) {
    return node;
  }
  return (parent[node] = findParent(parent[node]));
};

const unionParent = (a, b) => {
  a = findParent(a);
  b = findParent(b);
  if (a < b) {
    parent[b] = a;
  } else {
    parent[a] = b;
  }
};

while (true) {
  [m, n] = input[idx++].split(" ").map(Number);
  if (m === 0 && n === 0) {
    break;
  }

  edges.length = 0;
  for (let i = 0; i < n; i++) {
    const [x, y, z] = input[idx++].split(" ").map(Number);
    edges.push([x, y, z]);
  }

  edges.sort((a, b) => a[2] - b[2]);
  parent = Array.from({ length: m }, (_, i) => i);
  let totalCost = 0;
  let minCost = 0;

  for (const [u, v, cost] of edges) {
    totalCost += cost;
    if (findParent(u) !== findParent(v)) {
      unionParent(u, v);
      minCost += cost;
    }
  }
  console.log(totalCost - minCost);
}
