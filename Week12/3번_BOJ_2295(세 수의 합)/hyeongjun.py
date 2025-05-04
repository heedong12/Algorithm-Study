from itertools import combinations_with_replacement
def solve():
    hap = {x+y for x,y in combinations_with_replacement(arr, 2)}
    for k in range(n-1, -1, -1):
        for x in range(k):
            if arr[k] - arr[x] in hap:
                return arr[k]
    return None
n = int(input())
arr = sorted([int(input()) for _ in range(n)])
print(solve())
