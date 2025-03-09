const [N, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [K, ...numbers] = input.split(" ").map(Number);

const factorial = (n) => (n <= 1 ? 1 : n * factorial(n - 1));

const getKthPermutation = (N, K) => {
  let nums = Array.from({ length: N }, (_, i) => i + 1);
  let result = [];
  K--;

  for (let i = N; i > 0; i--) {
    let fact = factorial(i - 1);
    let index = Math.floor(K / fact);
    result.push(nums[index]);
    nums.splice(index, 1);
    K %= fact;
  }
  console.log(result.join(" "));
};

const getPermutationIndex = (N, perm) => {
  let nums = Array.from({ length: N }, (_, i) => i + 1);
  let count = 0;
  for (let i = 0; i < N; i++) {
    let idx = nums.indexOf(perm[i]);
    count += idx * factorial(N - i - 1);
    nums.splice(idx, 1);
  }
  console.log(count + 1);
};

if (K === 1) {
  getKthPermutation(N, numbers[0]);
} else {
  getPermutationIndex(N, numbers);
}
