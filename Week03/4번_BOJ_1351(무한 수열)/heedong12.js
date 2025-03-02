const [N, P, Q] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let map = new Map();
map.set(0, 1);

const findValue = (key) => {
  if (!map.has(key))
    map.set(
      key,
      findValue(Math.floor(key / P)) + findValue(Math.floor(key / Q))
    );

  return map.get(key);
};

console.log(findValue(N));
