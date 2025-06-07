def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x_root = find(x)
    y_root = find(y)
    if x_root != y_root:
        parent[y_root] = x_root

n, m = map(int, input().split())
truth = list(map(int, input().split()))
truth_people = truth[1:]

parent = [i for i in range(n + 1)]
parties = []

for _ in range(m):
    party = list(map(int, input().split()))[1:]
    for i in range(1, len(party)):
        union(party[0], party[i])
    parties.append(party)

truth_roots = set(find(p) for p in truth_people)

result = 0
for party in parties:
    if all(find(p) not in truth_roots for p in party):
        result += 1

print(result)
