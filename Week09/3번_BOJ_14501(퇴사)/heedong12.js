let [N, ...nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
const numArr = [[0, 0]];
nums.map((item) => numArr.push(item.split(" ").map(Number)));

let dp = new Array(N + 2).fill(0);

for (let i = 1; i <= N; i++) {
  dp[i] = Math.max(dp[i], dp[i - 1]);

  const [day, pay] = numArr[i];
  const nextDay = i + day;

  if (nextDay <= N + 1) {
    dp[nextDay] = Math.max(dp[nextDay], dp[i] + pay);
  }
}

console.log(Math.max(...dp));
