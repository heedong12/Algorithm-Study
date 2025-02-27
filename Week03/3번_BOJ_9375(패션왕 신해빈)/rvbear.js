const [t, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let ans = [];
let c = Number(t);

while (c--) {
  let n = Number(input.shift());
  let map = new Map();

  for (let i = 0; i < n; i++) {
    let [name, kind] = input.shift().trim().split(" ");
    map.set(kind, map.get(kind) === undefined ? 1 : map.get(kind) + 1);
  }

  let res = 1;
  for (let v of map.values()) {
    res *= v + 1;
  }

  ans.push(res - 1);
}

console.log(ans.join("\n"));
