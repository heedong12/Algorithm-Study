const [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const arr = inputs.map((item) => item.split(" ").map(Number));
let minCost = Number.MAX_VALUE;

const findMinCost = (cost, visited, start) => {
  // 모든 도시를 방문했고 출발지로 돌아갈 수 있는 경우
  if (visited.every((item) => item) && arr[start][0] > 0) {
    cost += arr[start][0];
    // 최소 비용을 구함
    return (minCost = Math.min(minCost, cost));
  }

  for (let j = 1; j < N; j++) {
    // 같은 도시로 이동하는 경우, 방문한 경우, 갈 수 없는 경우를 제외
    if (start != j && !visited[j] && arr[start][j] > 0) {
      visited[j] = true;
      findMinCost(cost + arr[start][j], visited, j);
      visited[j] = false;
    }
  }
};

const visited = Array.from({ length: N }, (_) => false);
visited[0] = true;
findMinCost(0, visited, 0);

console.log(minCost);
