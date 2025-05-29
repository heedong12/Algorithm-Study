let [N, K] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let visited = new Array(100001).fill(false);
const bfs = (cur) => {
  let queue = [[cur, 0]];
  let idx = 0;
  visited[cur] = true;
  while (queue.length > 0) {
    let [curNum, count] = queue[idx++];

    if (curNum === K) return count;

    for (let next of [curNum + 1, curNum - 1, curNum * 2]) {
      if (next >= 0 && next < 100001 && !visited[next]) {
        visited[next] = true;
        queue.push([next, count + 1]);
      }
    }
  }
};

console.log(bfs(N, K));
