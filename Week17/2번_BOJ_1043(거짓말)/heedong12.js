let [NM, truth, ...party] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let [N, M] = NM.split(" ").map(Number);
truth = truth.split(" ").map(Number);

if (truth[0] === 0) {
  console.log(M);
  process.exit(0);
}

let graph = Array.from({ length: N + 1 }, () => []);

let partyList = party.map((v) => v.split(" ").slice(1).map(Number));

for (let i = 0; i < M; i++) {
  let partyPeople = partyList[i];
  for (let j = 0; j < partyPeople.length; j++) {
    for (let k = j + 1; k < partyPeople.length; k++) {
      graph[partyPeople[j]].push(partyPeople[k]);
      graph[partyPeople[k]].push(partyPeople[j]);
    }
  }
}

let truthPeople = Array(N + 1).fill(false);
let queue = truth.slice(1);

while (queue.length > 0) {
  let person = queue.pop();
  if (truthPeople[person]) continue;
  truthPeople[person] = true;

  for (let truth of graph[person]) {
    if (!truthPeople[truth]) {
      queue.push(truth);
    }
  }
}

let result = 0;
for (let i = 0; i < M; i++) {
  if (partyList[i].every((person) => !truthPeople[person])) result++;
}

console.log(result);
