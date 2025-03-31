let [a, p] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let arr = [a];

while (true) {
  let temp = arr[arr.length - 1],
    target = 0;

  while (temp > 0) {
    target += Math.pow(temp % 10, p);
    temp = Math.floor(temp / 10);
  }

  if (arr.includes(target)) {
    console.log(arr.indexOf(target));
    break;
  }

  arr.push(target);
}
