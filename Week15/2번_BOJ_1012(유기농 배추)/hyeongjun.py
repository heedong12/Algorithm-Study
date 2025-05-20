def check(i,j, maxX, maxY):
    stack = [(i,j)]
    while stack:
        x, y = stack.pop()
        for dx,dy in direction:
            if 0<= x+dx < maxX and 0<=y+dy < maxY:
                if Map[x+dx][y+dy] == 1 and not visited[x+dx][y+dy]:
                    visited[x+dx][y+dy] = 1
                    stack.append((x+dx,y+dy))
    return 1

t = int(input())
direction = [(1,0) , (-1,0) , (0,1) , (0,-1)]
for _ in range(t):
    m, n, k = map(int, input().split())
    Map = [[0]*m for _ in range(n)]
    for _ in range(k):
        j , i = map(int,input().split())
        Map[i][j] = 1
    visited = [[False]*m for _ in range(n)]
    result = 0
    for i in range(m):
        for j in range(n):
            if Map[i][j] == 1 and visited[i][j] == False:
                visited[i][j] = True
                result += check(i,j,n,m)
    print(result)