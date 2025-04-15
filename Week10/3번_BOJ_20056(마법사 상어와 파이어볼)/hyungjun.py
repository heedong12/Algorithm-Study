class Fireball:
    def __init__(self, mass, velo, direc):
        self.mass = mass  # 질량 저장
        self.velocity = velo  # 속력 저장
        self.direction = direc  # 방향 저장
        self.otherDirection = []  # 방향 짝수/홀수 체크용 리스트

    def __getstate__(self):
        return self.mass, self.velocity, self.direction  # 현재 상태 반환

    def setfire(self, mass, velo, direc):
        self.mass = mass  # 질량 재설정
        self.velocity = velo  # 속력 재설정
        self.direction = direc  # 방향 재설정

    def addOtherDirection(self, other):
        self.otherDirection.append(other)  # 방향 짝/홀 기록

    def getOtherDirection(self):
        return self.otherDirection  # 방향 기록 리스트 반환

    def reset(self):
        self.mass = 0
        self.velocity = 0
        self.direction = 0
        self.otherDirection = []  # 파이어볼 초기화

# 입력 받음 (격자 크기, 파이어볼 개수, 명령 반복 횟수)
n , m , k = map(int, input().split())

# 방향 이동용 델타 배열 (상, 우상, 우, 우하, 하, 좌하, 좌, 좌상)
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

# 맵과 파이어볼 객체 배열 초기화
Map = [[0] * n for _ in range(n)]  # 위치별 파이어볼 개수 저장
F = [[Fireball(0, 0, 0) for _ in range(n)] for _ in range(n)]  # 파이어볼 상태 저장
command = []  # 이동할 파이어볼 명령 큐

# 파이어볼 정보 입력 및 초기 배치
for i in range(m):
    r , c, M, s, d = map(int, input().split())
    Map[r-1][c-1] = 1  # 해당 좌표에 파이어볼 1개 배치
    f = Fireball(M,s,d)  # 파이어볼 객체 생성
    command.append((r - 1, c - 1,f))  # 명령 큐에 추가

# k번 명령 반복
for repeat in range(k):
    newMap = [[0] * n for _ in range(n)]  # 이동 후 파이어볼 개수 저장용
    newF = [[Fireball(0, 0, 0) for _ in range(n)] for _ in range(n)]  # 이동 후 파이어볼 상태 저장용

    # 파이어볼 이동 처리
    while command:
        r, c, f = command.pop(0)  # 현재 좌표와 파이어볼 꺼냄
        M, s, d = f.__getstate__()  # 파이어볼 상태 조회
        nr = (r + dr[d] * s) % n  # 새 행 위치 계산 (원형 맵이라 나머지 연산)
        nc = (c + dc[d] * s) % n  # 새 열 위치 계산
        newMap[nr][nc] += 1  # 새 위치에 파이어볼 개수 증가

        if newMap[nr][nc] >= 2:  # 두 개 이상 모인 경우
            curM, curS, _ = newF[nr][nc].__getstate__()
            newF[nr][nc].setfire(M + curM, s + curS, d)  # 질량, 속도 합침 (방향은 임시)
            newF[nr][nc].addOtherDirection(d % 2)  # 방향 짝수/홀수 저장
        else:  # 처음 오는 경우
            newF[nr][nc].setfire(M, s, d)  # 상태 저장
            newF[nr][nc].addOtherDirection(d % 2)  # 방향 짝/홀 저장

    Map = newMap  # 이동 결과를 원본 맵으로 복사
    F = newF  # 파이어볼 정보도 복사

    if repeat == k - 1:  # 마지막 반복이면 더 이상 합치기 작업 안 함
        break

    # 2개 이상인 위치에서 파이어볼 쪼개기
    for i in range(n):
        for j in range(n):
            if Map[i][j] >= 2:  # 파이어볼 2개 이상일 때
                number = Map[i][j]
                M, s, _ = F[i][j].__getstate__()

                if M // 5 == 0:  # 나눠진 질량이 0이면 소멸
                    Map[i][j] = 0
                    F[i][j].reset()
                    continue

                temp = F[i][j].getOtherDirection()  # 방향 배열 조회

                # 모두 짝수거나 모두 홀수면 0,2,4,6 아니면 1,3,5,7 방향으로 나눔
                if sum(temp) == len(temp) or sum(temp) == 0:
                    direct = [0, 2, 4, 6]
                else:
                    direct = [1, 3, 5, 7]

                # 4개의 파이어볼로 쪼개서 명령 큐에 추가
                for di in direct:
                    f = Fireball(M // 5, s // number, di)
                    command.append((i, j, f))

            elif Map[i][j] == 1:  # 파이어볼 1개면 그냥 이동 명령 추가
                M, s, d = F[i][j].__getstate__()
                f = Fireball(M, s, d)
                command.append((i, j, f))

            F[i][j].reset()  # 해당 칸 정보 초기화

# 최종 질량 합산
result = 0
for i in range(n):
    for j in range(n):
        if Map[i][j] >= 2:  # 2개 이상인 경우 쪼개진 파이어볼 기준으로 질량 계산
            M, _, _ = F[i][j].__getstate__()
            result += 4 * (M // 5)
        elif Map[i][j] == 1:  # 1개면 그대로 질량 더함
            M, _, _ = F[i][j].__getstate__()
            result += M

print(result)  # 결과 출력