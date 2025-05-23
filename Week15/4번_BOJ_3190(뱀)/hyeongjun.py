from collections import deque

n = int(input())
k = int(input())

Map = [[0] * n for i in range(n)]
Map[0][0] = 1
apple = set()
for _ in range(k):
    x, y = map(int, input().split())
    apple.add((x-1, y-1))
l = int(input())
conditions = []
for _ in range(l):
    s, b = input().rstrip().split()
    s = int(s)
    conditions.append((s, b))

direction = deque([(0,1),(1,0),(0,-1),(-1,0)])
cur_dir = direction[0]
seconds = 0
head = [(0,0)]
condition_sec, condition_dir = conditions.pop(0)
while True:
    if seconds == condition_sec:
        if condition_dir == "D":
            direction.rotate(-1)
            cur_dir = direction[0]
        else:
            direction.rotate(1)
            cur_dir = direction[0]
        if conditions:
            condition_sec, condition_dir = conditions.pop(0)

    dx, dy = cur_dir

    x, y = head[-1]
    if x+dx <0 or x+dx >= n or y+dy <0 or y+dy >= n or Map[x+dx][y+dy] == 1:
        print(seconds + 1)
        break
    Map[x+dx][y+dy] = 1
    head.append((x + dx, y + dy))
    if (x+dx, y+dy) in apple:
        apple.remove((x+dx, y+dy))
    else:
        del_x,del_y =head.pop(0)
        Map[del_x][del_y] = 0
    seconds += 1