package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class _20056 {
    static int N, M, K;
    static List<Fireball> fireballs = new ArrayList<>();
    static List<Fireball>[][] grid;
    static int _id = 0;

    public static class Fireball {
        private int id;
        private int r, c, m, s, d;
        public Fireball(int r, int c, int m, int s, int d) {
            this.id = _id++;
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    // 위, 오+위, 오, 오+아래, 아래, 왼+아래, 왼, 왼+위
    static int[] dirR = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirC = {0, 1, 1, 1, 0, -1, -1, -1};
    static void move() {
        for(Fireball f : fireballs) {
            grid[f.r][f.c].remove(f); // 기존의 위치에 있는 fireball 제거
            int nextR = (f.r + (dirR[f.d] * f.s %N)+N)%N;
            int nextC = (f.c + (dirC[f.d] * f.s %N)+N)%N;

            f.r = nextR;
            f.c = nextC;

            grid[f.r][f.c].add(f); // 새 위치의 격자에 fireball 추가
        }
    }

    static void nextProcessing() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j].size() > 1) {
                    // 현재 격자 위치에 fireball이 2개 이상 있을 경우
                    int newM = 0;
                    int newS = 0;
                    boolean allEven = true; // 모두 짝수인지
                    boolean allOdd = true; // 모두 홀수인지
                    for(Fireball f : grid[i][j]) {
                        newM += f.m;
                        newS += f.s;
                        if(f.d % 2 != 0) allEven = false;
                        if(f.d %2 != 1) allOdd = false;
                        fireballs.remove(f); // 합쳐질 기존의 파이어볼 제거
                    }
                    newM /= 5;
                    newS /= grid[i][j].size();

                    grid[i][j].clear();
                    if(newM > 0) {
                        int[] newDirs = (allEven || allOdd)
                                ? new int[]{0,2,4,6} : new int[]{1,3,5,7};
                        for(int d: newDirs) {
                            Fireball newFireball = new Fireball(i, j, newM, newS, d);
                            fireballs.add(newFireball);
                            grid[i][j].add(newFireball);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 격자 사이즈
        M = Integer.parseInt(input[1]); // 파이어볼 개수
        K = Integer.parseInt(input[2]); // 이동 명령 횟수

        grid = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++) { // 파이어볼 정보 입력받기
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) -1;
            int c = Integer.parseInt(input[1]) -1;
            int m = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            int d  = Integer.parseInt(input[4]);

            Fireball fireball = new Fireball(r, c, m, s, d);
            fireballs.add(fireball);
            grid[r][c].add(fireball);
        }

        while(K-- > 0) { // 파이어볼 이동
            move();
            nextProcessing();
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!grid[i][j].isEmpty()) {
                    for(Fireball f : grid[i][j]) {
                        answer += f.m;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
