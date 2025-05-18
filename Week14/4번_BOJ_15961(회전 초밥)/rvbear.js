let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, d, k, c] = input.shift().split(" ").map(Number);
let sushi = input.map(Number);
let check = Array(d + 1).fill(0);

let ans = 1;
check[c]++;
for (let i = 0; i < k; i++) {
  if (check[sushi[i]] === 0) {
    ans++;
  }

  check[sushi[i]]++;
}

let cnt = ans;
for (let i = 1; i < n; i++) {
  let temp = sushi[i - 1];
  check[temp]--;

  if (check[temp] === 0) {
    cnt--;
  }

  let add = sushi[(i + k - 1) % n];
  if (check[add] === 0) {
    cnt++;
  }
  check[add]++;

  ans = Math.max(ans, cnt);
}

console.log(ans);
