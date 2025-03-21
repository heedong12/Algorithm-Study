const [num, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let [N, K] = num.split(" ").map(Number);

// K가 5보다 작은 경우에는 무조건 0
if (K < 5) {
  console.log(0);
  process.exit(0);
}

// 필수로 배워야하는 글자
const essential = new Set(["a", "c", "i", "n", "t"]);
K -= 5;

// 배워야 할 글자
let need = new Set();
// 필수를 제외한 단어들
let words = [];
let answer = 0;
// 'acint'로 이루어진 단어는 배울 필요 X
let noNeedToLearn = 0;

for (let input of inputs) {
  // 앞뒤로 4글자씩 자름
  let sliceWord = input.slice(4, input.length - 4).split("");
  const word = new Set();

  sliceWord.map((item) => {
    if (!essential.has(item)) {
      word.add(item);
      need.add(item);
    }
  });

  if (word.size === 0) noNeedToLearn += 1;
  else words.push(word);
}

// set -> 배열로 변환
let needArr = [...need];

const findWord = (idx, learned, count) => {
  if (count === K || learned.size === need.size) {
    let cnt = 0;
    words.forEach((item) => {
      if ([...item].every((word) => learned.has(word))) cnt++;
    });

    return (answer = Math.max(answer, cnt));
  }

  for (let i = idx; i < needArr.length; i++) {
    learned.add(needArr[i]);
    findWord(i + 1, learned, count + 1);
    learned.delete(needArr[i]);
  }
};

findWord(0, new Set(), 0);

console.log(answer + noNeedToLearn);
