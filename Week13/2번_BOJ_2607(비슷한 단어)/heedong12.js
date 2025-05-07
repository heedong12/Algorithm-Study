let [_, standard, ...words] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const getMap = (word) => {
  const map = new Map();
  for (let c of word) {
    map.set(c, (map.get(c) ?? 0) + 1);
  }
  return map;
};
let standardMap = getMap(standard);

let count = 0;

for (let word of words) {
  const curMap = getMap(word);
  let diff = 0;

  const allKeys = new Set([...standardMap.keys(), ...curMap.keys()]);
  for (let c of allKeys) {
    const stdCount = standardMap.get(c) ?? 0;
    const curCount = curMap.get(c) ?? 0;
    diff += Math.abs(stdCount - curCount);
  }

  if (
    diff === 0 ||
    diff === 1 ||
    (diff === 2 && standard.length === word.length)
  ) {
    count++;
  }
}

console.log(count);
