const [n, p, q] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ");

const dict = {};
dict[0] = 1;

function find(key) {
  if (key in dict) {
    return dict[key];
  }

  return (dict[key] = find(Math.floor(key / p)) + find(Math.floor(key / q)));
}

console.log(find(n));
