import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = Integer.MIN_VALUE;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int[][] copy;

    static void countSafeZone(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        countSafeZone(copy);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0);

        System.out.println(max);
    }
}
