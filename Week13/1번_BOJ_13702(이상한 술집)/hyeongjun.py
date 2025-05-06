def count(arr, target ):
    num = 0
    for i in arr:
        num += i // target
    return num

n , k = map(int, input().split())
drink = [ int(input()) for _ in range(n) ]
start = 0
end = max(drink)
while start <= end:
    mid = (start + end) // 2
    temp = count(drink, mid)
    if temp >= k:
        start = mid + 1
    else:
        end = mid - 1
print(end)