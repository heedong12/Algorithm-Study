const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let t = Number(input.shift());
let ans = [];

while (t-- > 0) {
  let [n, m] = input.shift().split(" ").map(Number);
  let arrA = input.shift().split(" ").map(Number);
  let arrB = input.shift().split(" ").map(Number);

  arrB.sort((a, b) => a - b);

  let cnt = 0;
  arrA.map((v) => {
    let start = 0,
      end = m - 1;

    while (start <= end) {
      let mid = Math.floor((start + end) / 2);
      if (arrB[mid] < v) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    cnt += start;
  });

  ans.push(cnt);
}

console.log(ans.join("\n"));
