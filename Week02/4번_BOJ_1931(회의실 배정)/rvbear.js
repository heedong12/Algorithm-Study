const [N, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let meetings = Array.from(Array(Number(N)), () => new Array(2));

for (let i = 0; i < N; i++) {
  [meetings[i][0], meetings[i][1]] = input[i].split(" ");
}

meetings.sort(function (a, b) {
  return a[1] === b[1] ? a[0] - b[0] : a[1] - b[1];
});

let cnt = 0,
  endTime = 0;

meetings.map((meeting) => {
  if (endTime <= Number(meeting[0])) {
    cnt++;
    endTime = Number(meeting[1]);
  }
});

console.log(cnt);
