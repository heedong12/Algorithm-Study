n ,d, k ,c = map(int,input().split())
sushi = []
result = 0
count = [0] * (d+1)
for _ in range(n):
    num = int(input())
    sushi.append(num)

for i in range(k):
    if count[sushi[i]] == 0:
        result += 1
    count[sushi[i]] += 1
if count[c] == 0:
    result += 1

max_result = 0
for i in range(1,n):
    out = sushi[i-1]
    count[out] -= 1
    if count[out] == 0:
        result -= 1

    inp = sushi[(i+k-1) % n]
    if count[inp] == 0:
        result += 1
    count[inp] += 1

    if count[c] == 0:
        result += 1
    max_result = max(max_result, result)
print(max_result)