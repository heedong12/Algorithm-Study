def solve(node,n,price):
    if node >= n :
        result[0] = max(price,result[0])
        return
    for i in range(node,n):
        if not visited[i]:
            visited[i] = True
            if i + arrT[i] <= n:
                solve(i+arrT[i],n,price+arrP[i])
            else:
                solve(n+arrT[i],n,price)
            visited[i] = False

n = int(input())
arrT = []
arrP = []
for _ in range(n):
    t, p = map(int, input().split())
    arrT.append(t)
    arrP.append(p)
result = [0]
visited = [False] * n
solve(0,n,0)
print(result[0])
