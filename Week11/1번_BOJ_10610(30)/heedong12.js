let N = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("");

if (!N.includes("0")) {
  console.log(-1);
  process.exit(0);
} else {
  let sum = N.reduce((acc, cur) => {
    return (acc += Number(cur));
  }, 0);
  if (sum % 3 != 0) console.log(-1);
  else {
    N.sort((a, b) => Number(b) - Number(a));
    console.log(N.join(""));
  }
}
