let [n, ...arr] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

arr.sort((a, b) => a - b);

const binarySearch = (target, arr) => {
  let start = 0,
    end = n;

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);

    if (arr[mid] === target) {
      return true;
    }

    if (arr[mid] < target) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  return false;
};

loop: for (let i = n - 1; i >= 0; i--) {
  for (let j = i; j >= 0; j--) {
    for (let k = j; k >= 0; k--) {
      let target = arr[i] - (arr[j] + arr[k]);

      if (target <= 0) {
        break;
      }

      if (binarySearch(target, arr)) {
        console.log(arr[i]);
        break loop;
      }
    }
  }
}
