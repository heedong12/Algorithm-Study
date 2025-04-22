from copy import deepcopy
from itertools import combinations

def bfs(M):
    newStack = deepcopy(stack)
    while newStack:
        x, y = newStack.pop(0)
        visited[x][y] = True
        for dx, dy in directions:
            if 0 <= x + dx < n and 0 <= y + dy < m:
                if not visited[x + dx][y + dy] and M[x + dx][y + dy] == 0:
                    newStack.append((x + dx, y + dy))
                    M[x + dx][y + dy] = 2

n , m = map(int,input().split())

Map = []
stack = []
blank = []
initvisited = [[False] * m for _ in range(n) ]
directions = [(0,1) , (0,-1) , (1,0) , (-1,0)]
for row in range(n):
    l = list(map(int, input().split()))
    for a in range(m):
        if l[a] == 2:
            stack.append((row,a))
        elif l[a] == 0:
            blank.append((row,a))
    Map.append(l)

wall = 3
Maxresult = 0
for comb in combinations(blank, 3):
    newMap = deepcopy(Map)
    for x , y in comb:
        newMap[x][y] = 1
    visited = deepcopy(initvisited)
    bfs(newMap)
    result = 0
    for i in range(n):
        for j in range(m):
            if newMap[i][j] == 0:
                result += 1
    Maxresult = max(Maxresult, result)
print(Maxresult)


