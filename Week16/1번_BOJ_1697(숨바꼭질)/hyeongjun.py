from collections import deque

def solve(n, target):
    queue = deque([(n, 0)])
    visited = set()
    while queue:
        n, att = queue.popleft()
        if n == target:
            return att
        if n not in visited:
            visited.add(n)
            if n > 0:
                queue.append((n-1, att+1))
            if n < 100000:
                queue.append((n+1, att+1))
            if n <= 50000:
                queue.append((n*2, att+1))
    return min(attempt,att)

n, k = map(int, input().split())

attempt = float('inf')
print(solve(n, k))