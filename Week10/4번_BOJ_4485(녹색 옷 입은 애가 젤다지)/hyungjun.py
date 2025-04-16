def dfs(n):
    while stack:
        x, y = stack.pop(0)
        for dx, dy in directions:
            if 0<= x+dx < n and 0<= y+dy < n:
                if dp[x+dx][y+dy] < dp[x][y]:
                    continue
                else:
                    if dp[x][y] + arr[x+dx][y+dy] < dp[x+dx][y+dy]:
                        dp[x+dx][y+dy] = dp[x][y] + arr[x+dx][y+dy]
                        stack.append((x+dx, y+dy))
tc = 0
while True:
    tc += 1
    n = int(input())
    if n == 0: break
    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    stack = [(0,0)]
    dp = [[float('inf')] *n for _ in range(n)]
    dp[0][0] = arr[0][0]
    dfs(n)
    print(f'Problem {tc}: {dp[n-1][n-1]}')