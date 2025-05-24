let [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

if (N === "100") {
  console.log(0);
} else {
  let broken = inputs.length === 2 ? inputs[1].split(" ") : [];
  let min = Math.abs(100 - +N);

  for (let i = 0; i <= 1000000; i++) {
    let str = i.toString();
    let canMake = str.split("").every((item) => !broken.includes(item));

    if (canMake) min = Math.min(min, Math.abs(i - N) + str.length);
  }
  console.log(min);
}
