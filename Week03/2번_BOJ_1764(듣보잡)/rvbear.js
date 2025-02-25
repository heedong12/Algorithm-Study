const [input, ...names] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input.split(" ");
const map = new Map();
let res = 0;
let notListenAndSee = [];

names.map((name, idx) => {
  if (idx < Number(n)) {
    map.set(name.trim(), name.trim());
  } else {
    if (map.has(name.trim())) {
      res++;
      notListenAndSee.push(name.trim());
    }
  }
});

console.log(res);
notListenAndSee.sort();
console.log(notListenAndSee.join("\n"));
