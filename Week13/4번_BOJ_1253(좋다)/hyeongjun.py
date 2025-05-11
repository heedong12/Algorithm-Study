n = int(input())
arr = list(map(int, input().split()))
arr.sort()
result = 0

for i in range(n):
    target = arr[i]
    left = 0
    right = n - 1

    while left < right:
        if left == i:
            left += 1
            continue
        if right == i:
            right -= 1
            continue

        s = arr[left] + arr[right]
        if s == target:
            result += 1
            break
        elif s < target:
            left += 1
        else:
            right -= 1

print(result)