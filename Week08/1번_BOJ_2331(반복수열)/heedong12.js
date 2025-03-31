let [A, P] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const arr = [A];

while (true) {
  let newNum = arr[arr.length - 1]
    .toString()
    .split("")
    .reduce((acc, cur) => {
      return (acc += Math.pow(cur, P));
    }, 0);

  if (arr.includes(newNum)) {
    console.log(arr.indexOf(newNum));
    break;
  }

  arr.push(newNum);
}
