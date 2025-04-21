def dfs(x,y,w,h):
    stack = [(x,y)]
    while stack:
        x,y = stack.pop()
        for dx,dy in directions:
            if 0 <= x + dx <h and 0<= y + dy <w:
                if not visited[x+dx][y+dy] and Map[x+dx][y+dy] == 1:
                    visited[x+dx][y+dy] = True
                    stack.append((x+dx,y+dy))
    return 1


def solve(w, h):
    island = 0
    for i in range(h):
        for j in range(w):
            if not visited[i][j] and Map[i][j] == 1:
                visited[i][j] = True
                island += dfs(i,j,w,h)
    return island

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    Map = []
    visited = [[False] * w for _ in range(h)]
    for _ in range(h):
        Map.append(list(map(int, input().split())))
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1) , (-1, -1), (1, -1) , (-1, 1), (1, 1)]
    print(solve(w, h))