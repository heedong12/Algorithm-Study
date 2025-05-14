def check_row(row):
    cnt = 1
    max_cnt = 1
    for i in range(1, n):
        if M[row][i] == M[row][i-1]:
            cnt += 1
            max_cnt = max(max_cnt, cnt)
        else:
            cnt = 1
    return max_cnt


def check_col(col):
    cnt = 1
    max_cnt = 1
    for i in range(1, n):
        if M[i][col] == M[i-1][col]:
            cnt += 1
            max_cnt = max(max_cnt, cnt)
        else:
            cnt = 1
    return max_cnt

n = int(input())
M = []
for i in range(n):
    M.append(list(input()))

direction = [(1,0) , (-1,0) , (0,1) , (0,-1)]
result = 0
for i in range(n):
    for j in range(n):
        result = max(result,check_row(i),check_col(j))
        for dx, dy in direction:
            if 0<= i + dx < n and 0<= j + dy < n:
                M[i][j] , M[i+dx][j+dy] = M[i+dx][j+dy], M[i][j]
                result = max(result, check_row(i), check_col(j))
                M[i][j], M[i + dx][j + dy] = M[i + dx][j + dy], M[i][j]

print(result)