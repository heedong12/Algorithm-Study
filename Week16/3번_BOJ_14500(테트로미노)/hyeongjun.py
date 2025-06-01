n, m = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
max_sum = [0]

def btk(x, y, depth, total):
    if depth == 4:
        max_sum[0] = max(max_sum[0], total)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
            visited[nx][ny] = True
            btk(nx, ny, depth + 1, total + Map[nx][ny])
            visited[nx][ny] = False

def check_h(x, y):
    for i in range(4):
        total = Map[x][y]
        for j in range(3):
            k = (i + j) % 4
            nx = x + dx[k]
            ny = y + dy[k]
            if not (0 <= nx < n and 0 <= ny < m):
                break
            total += Map[nx][ny]
        else:
            max_sum[0] = max(max_sum[0], total)

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        btk(i, j, 1, Map[i][j])
        visited[i][j] = False
        check_h(i, j)

print(max_sum[0])
