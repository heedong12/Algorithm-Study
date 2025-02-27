const [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const answer = [];

for (let i = 0; i < inputs.length; i++) {
  let testNum = inputs[i];
  let map = new Map();
  for (let j = i + 1; j <= i + Number(testNum); j++) {
    let [_, type] = inputs[j].split(" ");
    map.set(type, (map.get(type) || 0) + 1);
  }
  let sum = 1;
  map.forEach((item) => (sum *= Number(item) + 1));
  answer.push(sum - 1);
  i += Number(testNum);
}

console.log(answer.join("\n"));
