let [T, ...arr] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let answers = [];
const bfs = (A, B) => {
  let visited = new Array(10000).fill(false);
  // 숫자와 명령어 저장
  const queue = [[A, ""]];
  // 방문한 숫자에는 방문 표시
  visited[A] = true;
  let answer = "";

  while (queue.length > 0) {
    let [num, command] = queue.shift();

    if (num === B) {
      answer = command;
      break;
    }

    let D = (2 * num) % 10000;
    if (!visited[D]) {
      queue.push([D, command + "D"]);
      visited[D] = true;
    }

    let S = num === 0 ? 9999 : num - 1;
    if (!visited[S]) {
      queue.push([S, command + "S"]);
      visited[S] = true;
    }

    let L = (num % 1000) * 10 + Math.floor(num / 1000);
    if (!visited[L]) {
      queue.push([L, command + "L"]);
      visited[L] = true;
    }

    let R = (num % 10) * 1000 + Math.floor(num / 10);
    if (!visited[R]) {
      queue.push([R, command + "R"]);
      visited[R] = true;
    }
  }
  return answer;
};

for (let i = 0; i < Number(T); i++) {
  let [A, B] = arr[i].split(" ").map(Number);
  answers.push(bfs(A, B));
}

console.log(answers.join("\n"));
