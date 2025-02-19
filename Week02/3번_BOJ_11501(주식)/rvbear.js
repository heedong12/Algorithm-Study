const [t, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let ans = "";

for (let i = 0; i < t; i++) {
  const n = Number(inputs.shift());
  const val = inputs.shift().split(" ").map(Number);

  let maxVal = val[n - 1];
  let res = 0;

  for (let j = n - 2; j > -1; j--) {
    if (maxVal < val[j]) {
      maxVal = val[j];
    } else {
      res += maxVal - val[j];
    }
  }

  ans += res + "\n";
}

console.log(ans);
