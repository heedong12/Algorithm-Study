n = int(input())
amount = [int(input()) for _ in range(n)]
dp = [0] * n
if n == 1:
    print(amount[0])
elif n == 2:
    print(amount[1] + amount[0])
else:
    dp[0] = amount[0]
    dp[1] = amount[1] + amount[0]
    dp[2] = max(dp[1], amount[0] + amount[2], amount[1] + amount[2])
    for i in range(3, n):
        dp[i] = max(dp[i-1], dp[i-2] + amount[i], dp[i-3] + amount[i] + amount[i-1])
    print(dp[n-1])