const [num, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M, B] = num.split(" ").map(Number);
let maxHeight = 0;
let minheight = 256;

const arr = maps.map((item) => {
  let map = item.split(" ").map(Number);
  // 가장 높은 높이
  maxHeight = Math.max(...map, maxHeight);
  // 가장 낮은 높이
  minheight = Math.min(...map, minheight);
  return map;
});

let time = Number.MAX_VALUE;
let height = 0;
// 가장 낮은 높이 ~ 가장 높은 높이까지 반복문 실행
for (let i = minheight; i <= maxHeight; i++) {
  let add = 0;
  let remove = 0;

  for (let j = 0; j < N; j++) {
    for (let k = 0; k < M; k++) {
      // 목표 높이보다 낮음 -> 쌓아야됨
      if (arr[j][k] < i) add += i - arr[j][k];
      // 목표 높이보다 높음 -> 부셔야됨
      else if (arr[j][k] > i) remove += arr[j][k] - i;
    }
  }

  if (B - add + remove >= 0 && time >= add + remove * 2) {
    // 시간이 같다면 더 높은 높이 저장
    height = time === add + remove * 2 ? Math.max(height, i) : i;
    time = add + remove * 2;
  }
}

console.log(time + " " + height);
