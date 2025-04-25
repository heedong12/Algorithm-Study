def delete(check):
    stack = []
    for i in check:
        stack.append(i)
    while stack:
        cur = stack.pop(0)
        for i in range(n):
            if graph[cur][i] == 1:
                graph[cur][i] = 0
                indegree[i] -= 1
                if indegree[i] == 0:
                    stack.append(i)

n , m = map(int,input().split())

graph = [[0] * n for _ in range(n)]
indegree = [0] *n
for _ in range(m):
    a, b  = input().split()
    a, b = (ord(a) - ord('A')), (ord(b) - ord('A'))
    graph[a][b] = 1
    indegree[b] += 1

arr = list(input().split())
for i in range(1, len(arr)):
    arr[i] = ord(arr[i]) - ord('A')
check = set(arr[1:])
delete(check)
result = 0
visited = [False] * n
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            if not visited[j] and j not in check:
                visited[j] = True
                result += 1

print(result)