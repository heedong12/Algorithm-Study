let [NM, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, M] = NM.split(" ").map(Number);
maps = maps.map((item) => item.split(" ").map(Number));

let max = 0;
const directions = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const BFS = (startPoints, currentMap) => {
  const queue = [...startPoints];
  const visited = Array.from(Array(N), () => Array(M).fill(false));
  queue.forEach(([x, y]) => (visited[x][y] = true));

  while (queue.length > 0) {
    const [cx, cy] = queue.shift();

    for (const [dx, dy] of directions) {
      const nx = cx + dx;
      const ny = cy + dy;

      if (
        nx >= 0 &&
        nx < N &&
        ny >= 0 &&
        ny < M &&
        !visited[nx][ny] &&
        currentMap[nx][ny] === 0
      ) {
        currentMap[nx][ny] = 2;
        visited[nx][ny] = true;
        queue.push([nx, ny]);
      }
    }
  }

  let safeZone = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (currentMap[i][j] === 0) {
        safeZone++;
      }
    }
  }
  return safeZone;
};

const getZeroCoordinates = (currentMap) => {
  const zeros = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (currentMap[i][j] === 0) {
        zeros.push([i, j]);
      }
    }
  }
  return zeros;
};

const getVirusCoordinates = (currentMap) => {
  const viruses = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (currentMap[i][j] === 2) {
        viruses.push([i, j]);
      }
    }
  }
  return viruses;
};

const combinations = (arr, selectNumber) => {
  const results = [];
  if (selectNumber === 1) {
    return arr.map((element) => [element]);
  }
  // 가능한 조합만 뽑음
  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const smallerCombinations = combinations(rest, selectNumber - 1);
    const attached = smallerCombinations.map((combination) => [
      fixed,
      ...combination,
    ]);
    results.push(...attached);
  });
  return results;
};

const zeroCoordinates = getZeroCoordinates(maps); // 0의 위치들
const wallCombinations = combinations(zeroCoordinates, 3); // 가능한 조합
const initialVirusCoordinates = getVirusCoordinates(maps); // 2의 위치들

for (const walls of wallCombinations) {
  const tempMap = maps.map((row) => [...row]);
  walls.forEach(([wx, wy]) => {
    tempMap[wx][wy] = 1;
  });

  max = Math.max(max, BFS(initialVirusCoordinates, tempMap));
}

console.log(max);
