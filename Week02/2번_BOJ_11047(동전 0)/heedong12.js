const [nums, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let K = nums.split(" ").map(Number)[1];
const coins = inputs.reverse().filter((coin) => coin <= K);

const count = coins.reduce((acc, cur) => {
  let coinCount = Math.floor(K / cur);
  if (coinCount > 0) {
    acc += coinCount;
    K -= cur * coinCount;
  }
  return acc;
}, 0);

console.log(count);
