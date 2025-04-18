import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] pair = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static Queue<Fireball>[][] map;

    static class Fireball {
        int m, s, d, moved;

        public Fireball(int m, int s, int d, int moved) {
            this.m = m;
            this.s = s;
            this.d = d;
            this.moved = moved;
        }
    }

    static void move(int lv) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!map[i][j].isEmpty()) {
                    if (map[i][j].peek().moved > lv) {
                        break;
                    }

                    Fireball fb = map[i][j].poll();
                    int nr = (i + (N + pair[fb.d][0]) * fb.s) % N;
                    int nc = (j + (N + pair[fb.d][1]) * fb.s) % N;
                    map[nr][nc].offer(new Fireball(fb.m, fb.s, fb.d, fb.moved + 1));
                }
            }
        }
    }

    static void merge(int lv) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 1) {
                    int cnt = map[i][j].size();
                    int mSum = 0, sSum = 0, dir = 8, moved = lv + 1;
                    boolean flag = true;

                    while (!map[i][j].isEmpty()) {
                        Fireball fb = map[i][j].poll();
                        mSum += fb.m;
                        sSum += fb.s;

                        if (dir >= 8) {
                            dir = fb.d;
                        } else {
                            if (Math.abs(dir - fb.d) % 2 == 1) {
                                flag = false;
                            }
                        }
                    }

                    int start = flag ? 0 : 1;
                    mSum /= 5;
                    if (mSum == 0) {
                        continue;
                    }
                    sSum /= cnt;

                    for (int d = start; d < 8; d += 2) {
                        map[i][j].offer(new Fireball(mSum, sSum, d, moved));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;
            int m = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            int d = Integer.parseInt(input[4]);
            map[r][c].add(new Fireball(m, s, d, 0));
        }

        for (int i = 0; i < K; i++) {
            move(i);
            merge(i);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!map[i][j].isEmpty()) {
                    res += map[i][j].poll().m;
                }
            }
        }

        System.out.println(res);
    }
}
