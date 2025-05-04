from collections import defaultdict
import heapq

def dfs():
    visited = set()
    pq = [(0,0)]
    min_cost = 0
    while pq:
        cost, current = heapq.heappop(pq)
        if current not in visited:
            visited.add(current)
            min_cost += cost

            for node, z in graph[current]:
                heapq.heappush(pq, (z,node))
    return min_cost
while True:
    m , n = map(int,input().split())
    if m == n == 0:
        break
    total_cost = 0
    graph =defaultdict(list)
    for _ in range(n):
        x, y, z = map(int,input().split())
        total_cost += z
        graph[x].append((y, z))
        graph[y].append((x, z))
    result = dfs()
    print(total_cost-result)