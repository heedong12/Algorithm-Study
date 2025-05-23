target = int(input())
m = int(input())

if m:
    arr = set(input().split())
else:
    arr = set()

min_val = abs(target - 100)

for num in range(1000000):
    for digit in str(num):
        if digit in arr:
            break
    else:
        min_val = min(min_val, len(str(num)) + abs(num - target))

print(min_val)