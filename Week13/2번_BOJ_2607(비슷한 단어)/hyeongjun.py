from collections import defaultdict
from copy import deepcopy
n = int(input())
standard = input()
alpha = defaultdict(int)
for char in standard:
    alpha[char] += 1

result = 0
for i in range(n-1):
    string = input()
    diff = 0
    alpha_copy = deepcopy(alpha)
    for char in string:
        alpha_copy[char] -= 1
    for value in alpha_copy.values():
        diff += abs(value)

    len_diff = abs(len(standard) - len(string))
    if diff == 0:
        result += 1
    elif diff == 1 and len_diff == 1:  # 추가 or 삭제
        result += 1
    elif diff == 2 and len_diff == 0:  # 교체
        result += 1
print(result)