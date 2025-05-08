let [n, first, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let res = 0;

input.forEach((word) => {
  let firstArray = first.split("");
  let targetArray = word.split("");
  let changeCnt = 0;

  for (let w of targetArray) {
    let idx = firstArray.indexOf(w);

    if (idx !== -1) {
      firstArray.splice(idx, 1);
    } else {
      changeCnt++;
    }
  }

  if (changeCnt <= 1 && firstArray.length <= 1) {
    res++;
  }
});

console.log(res);
