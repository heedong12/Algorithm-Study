const [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

for (let i = 1; i < inputs.length; i = i + 2) {
  let stocks = inputs[i].split(" ").map(Number);
  let max = stocks[stocks.length - 1];
  let sum = 0;
  stocks.reverse().map((item, idx) => {
    max = Math.max(max, item);
    sum += max - item;
  });
  console.log(sum);
}
