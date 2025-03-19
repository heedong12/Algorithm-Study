const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let n = Number(input.shift());
let ans = [];

for (let i = 0; i < input.length; i++) {
  const [weight, height] = input[i].split(" ").map(Number);
  let rank = 1;
  for (let j = 0; j < input.length; j++) {
    if (i === j) {
      continue;
    }

    const [w, h] = input[j].split(" ").map(Number);
    if (weight < w && height < h) {
      rank++;
    }
  }
  ans.push(rank);
}

console.log(ans.join(" "));
