def solve(n):
    for i in range(n):
        for j in range(i, i + arr[i] + 1):
            dp[j] = min(dp[j],dp[i] + 1)
            if j == n-1:
                return

n = int(input())
arr = list(map(int, input().split()))
dp = [float('inf')] * n

if n == 1:
    print(0)
elif arr[0] == 0:
    print(-1)
else:
    dp[0] = 0
    solve(n)
    print(dp[n - 1] if dp[n - 1] != float('inf') else -1)
