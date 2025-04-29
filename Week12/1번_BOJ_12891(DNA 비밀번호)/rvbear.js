let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [s, p] = input[0].split(" ").map(Number);
let dna = input[1];
let min = input[2].split(" ").map(Number);
let find = Array(4).fill(0);

const check = () => {
  for (let i = 0; i < 4; i++) {
    if (find[i] < min[i]) {
      return false;
    }
  }

  return true;
};

for (let i = 0; i < p; i++) {
  if (dna.charAt(i) === "A") {
    find[0]++;
  } else if (dna.charAt(i) === "C") {
    find[1]++;
  } else if (dna.charAt(i) === "G") {
    find[2]++;
  } else if (dna.charAt(i) === "T") {
    find[3]++;
  }
}

let cnt = check() ? 1 : 0;

for (let i = 0, j = p; j < s; i++, j++) {
  if (dna.charAt(i) === "A") {
    find[0]--;
  } else if (dna.charAt(i) === "C") {
    find[1]--;
  } else if (dna.charAt(i) === "G") {
    find[2]--;
  } else if (dna.charAt(i) === "T") {
    find[3]--;
  }

  if (dna.charAt(j) === "A") {
    find[0]++;
  } else if (dna.charAt(j) === "C") {
    find[1]++;
  } else if (dna.charAt(j) === "G") {
    find[2]++;
  } else if (dna.charAt(j) === "T") {
    find[3]++;
  }

  cnt += check() ? 1 : 0;
}

console.log(cnt);
