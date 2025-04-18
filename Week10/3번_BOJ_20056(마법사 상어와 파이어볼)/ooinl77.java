import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N;
    static ArrayList<FireBall> fire = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fire.add(new FireBall(r, c, m, s, d));
        }

        while (K-- > 0) {
            List<FireBall>[][] map = new ArrayList[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            // 이동
            for (FireBall fb : fire) {
                int r = fb.r;
                int c = fb.c;
                int s = fb.s % N;

                int nr = r, nc = c;
                switch (fb.d) {
                    case 0: nr = (r - s - 1 + N) % N + 1; break;
                    case 1: nr = (r - s - 1 + N) % N + 1; nc = (c + s - 1) % N + 1; break;
                    case 2: nc = (c + s - 1) % N + 1; break;
                    case 3: nr = (r + s - 1) % N + 1; nc = (c + s - 1) % N + 1; break;
                    case 4: nr = (r + s - 1) % N + 1; break;
                    case 5: nr = (r + s - 1) % N + 1; nc = (c - s - 1 + N) % N + 1; break;
                    case 6: nc = (c - s - 1 + N) % N + 1; break;
                    case 7: nr = (r - s - 1 + N) % N + 1; nc = (c - s - 1 + N) % N + 1; break;
                }

                map[nr][nc].add(new FireBall(nr, nc, fb.m, fb.s, fb.d));
            }

            fire.clear();

            // 합치고 나누기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int size = map[i][j].size();
                    if (size == 0) continue;
                    // 클리어 후 사라진 1개 보존
                    if (size == 1) {
                        fire.add(map[i][j].get(0));
                        continue;
                    }

                    int mSum = 0; // 질량 합
                    int sSum = 0; // 속력 합
                    boolean odd = false; // 홀수면 1357
                    boolean even = false; // 짝수면 0246

                    for (FireBall fb : map[i][j]) {
                        mSum += fb.m;
                        sSum += fb.s;
                        if (fb.d % 2 == 0) even = true;
                        else odd = true;
                    }

                    int newM = mSum / 5; // 나눠질 질량
                    if (newM == 0) continue;
                    int newS = sSum / size; // 나눠질 속력
                    int startDir = (even && odd) ? 1 : 0; // 시작 방향 설정

                    for (int k = 0; k < 4; k++) {
                        int d = startDir + k * 2;
                        fire.add(new FireBall(i, j, newM, newS, d));
                    }
                }
            }
        }

        int result = 0;
        for (FireBall fb : fire) {
            result += fb.m;
        }
        System.out.println(result);
    }
}
