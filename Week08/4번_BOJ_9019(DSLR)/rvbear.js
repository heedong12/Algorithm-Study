let [t, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let ans = [];

const bfs = (start, target) => {
  let visit = Array(10000).fill(false);
  let q = [];
  q.push([start, ""]);
  visit[start] = true;

  while (q.length !== 0) {
    let [num, commend] = q.shift();
    if (target === num) {
      return commend;
    }

    let d = (num * 2) % 10000;
    if (!visit[d]) {
      q.push([d, commend + "D"]);
      visit[d] = true;
    }

    let s = num === 0 ? 9999 : num - 1;
    if (!visit[s]) {
      q.push([s, commend + "S"]);
      visit[s] = true;
    }

    let l = (num % 1000) * 10 + Math.floor(num / 1000);
    if (!visit[l]) {
      q.push([l, commend + "L"]);
      visit[l] = true;
    }

    let r = (num % 10) * 1000 + Math.floor(num / 10);
    if (!visit[r]) {
      q.push([r, commend + "R"]);
      visit[r] = true;
    }
  }
};

while (t-- > 0) {
  let [start, target] = input.shift().split(" ");
  ans.push(bfs(Number(start), Number(target)));
}

console.log(ans.join("\n"));
