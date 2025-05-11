t = int(input())
dp = [0] * (1000001)
for i in range(1, 1000001):
    for j in range(i, 1000001,i):
        dp[j] += i
for j in range(2, 1000001):
    dp[j] += dp[j-1]
for _ in range(t):
    n = int(input())
    print(dp[n])