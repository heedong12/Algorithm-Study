import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    //               방향 : 0 1 2 3 4 5 6 7 8
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<int[]>[][] grid;
    static List<int[]> fireballs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        grid = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int m = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            int d = Integer.parseInt(input[4]);
            fireballs.add(new int[]{r, c, m, s, d});
        }

        for (int i = 0; i < K; i++) {
            movement();
        }

        int result = 0;
        for (int[] fireball : fireballs) {
            result += fireball[2];
        }
        System.out.println(result);

    }

    public static void movement() {
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j].clear();
            }
        }
        for (int[] fireball : fireballs) {
            int r = fireball[0];
            int c = fireball[1];
            int m = fireball[2];
            int s = fireball[3];
            int d = fireball[4];

            int nr = (r + dr[d] * s) % N;
            int nc = (c + dc[d] * s) % N;

            if (nr < 0) nr += N;
            if (nc < 0) nc += N;

            grid[nr][nc].add(new int[]{nr, nc, m, s, d});
        }
        processGrid();
    }

    public static void processGrid() {
        List<int[]> newFireballs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].size() == 0) continue;
                if (grid[i][j].size() == 1) {
                    newFireballs.add(grid[i][j].get(0));
                } else {
                    int sumM = 0, sumS = 0;
                    boolean allEven = true, allOdd = true;
                    for (int[] fireball : grid[i][j]) {
                        sumM += fireball[2];
                        sumS += fireball[3];
                        if (fireball[4] % 2 == 0) {
                            allOdd = false;
                        } else {
                            allEven = false;
                        }
                    }
                    int[] nd;
                    if (allEven || allOdd) {
                        nd = new int[]{0, 2, 4, 6};
                    } else {
                        nd = new int[]{1, 3, 5, 7};
                    }

                    int nm = sumM / 5;
                    int ns = sumS / grid[i][j].size();
                    if (nm == 0) continue;

                    for (int d : nd) {
                        newFireballs.add(new int[]{i, j, nm, ns, d});
                    }
                }
            }
        }
        fireballs = newFireballs;
    }
}
