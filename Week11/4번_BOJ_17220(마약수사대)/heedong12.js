let [NM, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, M] = NM.split(" ").map(Number);

let map = new Map();

let nodes = new Set();
let values = new Set();
for (let i = 0; i < M; i++) {
  let [key, value] = inputs[i].split(" ");
  map.set(key, map.get(key) ? [value, ...map.get(key)] : [value]);
  nodes.add(key);
  values.add(value);
}

for (let v of values) {
  nodes.delete(v);
}
let origin = [...nodes];

let [_, ...drugs] = inputs.pop().split(" ");
for (let drug of drugs) {
  for (let [key, value] of map) {
    if (value.includes(drug)) {
      let idx = value.indexOf(drug);
      value.splice(idx, 1);
      if (value.length === 0) map.delete(key);
      else map.set(key, value);
    } else if (origin.includes(drug)) {
      map.delete(drug);
    }
  }
}

let answer = 0;
const DFS = (start) => {
  let stack = [start];
  let visited = new Set();
  visited.add(start);

  while (stack.length > 0) {
    let node = stack.pop();
    let lists = map.get(node);
    if (!lists) continue;

    for (let l of lists) {
      if (!visited[l.charCodeAt() - 65]) {
        stack.push(l);
        visited.add(l);

        answer++;
      }
    }
  }
};

for (let o of origin) {
  DFS(o);
}

console.log(answer);
