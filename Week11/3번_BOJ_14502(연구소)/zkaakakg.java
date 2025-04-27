import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int maxSafeZone = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0,0);
        System.out.print(maxSafeZone);

    }

    public static void dfs(int cnt, int start) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (arr[x][y] == 0) {
                arr[x][y] = 1;
                dfs(cnt + 1, i + 1); // 다음 칸부터 탐색
                arr[x][y] = 0;
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copyArr[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        copyArr[nx][ny] = 2;
                    }
                }
            }
        }
        cntSafeZone(copyArr);
    }

    public static void cntSafeZone(int[][] copyArr) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, cnt);
    }

}

