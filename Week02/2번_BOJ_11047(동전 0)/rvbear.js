const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let [N, ...coins] = input;
[N, K] = N.toString().split(" ").map(Number);
coins = coins.map(Number).sort((a, b) => b - a);

let cnt = 0;

for (const coin of coins) {
  cnt += parseInt(K / coin);
  K %= coin;

  if (K === 0) {
    break;
  }
}

console.log(cnt);
