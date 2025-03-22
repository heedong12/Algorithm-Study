const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, k] = input.shift().split(" ").map(Number);
let word = input.map((line) => line.trim().slice(4, -4));

let visit = new Array(26)
  .fill(false)
  .map((_, i) => [0, 2, 8, 13, 19].includes(i));

let max = 0;

const getIndex = (char) => char.charCodeAt(0) - "a".charCodeAt(0);

const backtracking = (alphabet, len) => {
  if (len === k) {
    const cnt = word.filter((w) =>
      [...w].every((char) => visit[getIndex(char)])
    ).length;
    max = Math.max(max, cnt);
    return;
  }

  for (let i = alphabet; i < 26; i++) {
    if (!visit[i]) {
      visit[i] = true;
      backtracking(i + 1, len + 1);
      visit[i] = false;
    }
  }
};

backtracking(0, 5);

console.log(k < 5 ? 0 : k === 26 ? n : max);
