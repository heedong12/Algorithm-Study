n = int(input())
arr = list(map(int, input().split()))
result = [-1] * n
stack = []
for i in range(n):
    if stack and arr[i] > arr[stack[-1]]:
        while stack and arr[stack[-1]] < arr[i]:
            result[stack.pop()] = arr[i]
    stack.append(i)
print(*result)