const [N, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let map = new Map();

input.forEach((text) => {
  let trimText = text.trim();

  map.set(trimText, trimText);
  let reverseText = trimText.split("").reverse().join("").trim();

  if (map.has(reverseText)) {
    console.log(
      reverseText.length,
      reverseText.charAt(Math.floor(reverseText.length / 2))
    );
  }
});
