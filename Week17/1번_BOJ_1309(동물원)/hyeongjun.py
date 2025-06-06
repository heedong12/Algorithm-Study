def solve():
    if n == 1:
        return dp[1]
    for i in range(2,n+1):
        dp[i] = (dp[i-1] * 2 + dp[i-2] ) % 9901

    return dp[n]

n = int(input())
dp = [1,3,7] + [0] * (n-2)
print(solve())