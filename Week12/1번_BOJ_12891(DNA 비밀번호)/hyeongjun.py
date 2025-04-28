def check():
    for i in range(4):
        if dp[i] < arr[i]:
            return 0
    return 1

s, p = map(int, input().split())
string = input()
arr = list(map(int, input().split()))

dic = { 'A' : 0 , 'C' : 1 , 'G' : 2 , 'T' : 3 }

result =0
dp = [0] * 4

for i in range(p):
    dp[dic[string[i]]] += 1
result += check()
for i in range(p,s):
    dp[dic[string[i-p]]] -= 1
    dp[dic[string[i]]] += 1
    result += check()

print(result)