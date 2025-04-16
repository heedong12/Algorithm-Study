let [nm, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, m] = nm.split(" ").map(Number);

let title = [];
let fight = [];

for (let i = 0; i < n; i++) {
  let [t, f] = input[i].split(" ");
  title.push(t);
  fight.push(+f);
}

let res = [];

for (let i = n; i < n + m; i++) {
  let temp = +input[i];

  let start = 0,
    end = n - 1,
    idx = 0;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2);

    if (temp <= fight[mid]) {
      end = mid - 1;
      idx = mid;
    } else {
      start = mid + 1;
    }
  }

  res.push(title[idx]);
}

console.log(res.join("\n"));
