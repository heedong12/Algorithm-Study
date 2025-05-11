let [n, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let num = input.split(" ").map(Number);

num.sort((a, b) => a - b);

let cnt = 0;
num.forEach((val, idx) => {
  let start = 0,
    end = num.length - 1;

  while (start < end) {
    if (start === idx) {
      start++;
      continue;
    } else if (end === idx) {
      end--;
      continue;
    }

    let sum = num[start] + num[end];
    if (sum === val) {
      cnt++;
      break;
    }

    if (sum < val) {
      start++;
    } else {
      end--;
    }
  }
});

console.log(cnt);
