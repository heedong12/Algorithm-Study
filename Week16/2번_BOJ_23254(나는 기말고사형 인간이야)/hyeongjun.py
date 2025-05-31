import sys
from heapq import *

input = sys.stdin.readline

n, m = map(int, input().split())
n *= 24
scores = list(map(int, input().split()))
efficiency = list(map(int, input().split()))

heap = []
for i in range(m):
    heap.append([-efficiency[i], i])

heapify(heap)

while heap:
    eff, index = heappop(heap)
    eff *= -1
    
    time_needed = (100 - scores[index]) // eff
    
    if (100 - scores[index]) % eff:
        heappush(heap, [-(100 - scores[index] - time_needed * eff), index])
    
    if time_needed >= n:
        time_needed = n
    
    scores[index] += eff * time_needed
    n -= time_needed
    
    if n == 0:
        break

print(sum(scores))
