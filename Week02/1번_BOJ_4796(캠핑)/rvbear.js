const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

for (let i = 0; i < input.length - 1; i++) {
  const [L, P, V] = input[i].split(" ").map(Number);
  let possibleDays = parseInt(V / P) * L + (V % P < L ? V % P : L);

  console.log(`Case ${i + 1}: ${possibleDays}`);
}
