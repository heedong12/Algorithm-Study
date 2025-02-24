let [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

inputs.sort((a, b) => a.length - b.length);
let answer = "";

loop: for (let i = 0; i < inputs.length; i++) {
  let reverse = inputs[i].split("").reverse().join("");
  if (reverse === inputs[i]) {
    answer = inputs[i];
    break loop;
  }
  for (let j = i + 1; j < inputs.length; j++) {
    if (inputs[j].includes(inputs[i]) || inputs[j].includes(reverse)) {
      answer = inputs[i];
      break loop;
    }
  }
}

let index = Math.floor(answer.length / 2);
console.log(answer.length + " " + answer.charAt(index));
