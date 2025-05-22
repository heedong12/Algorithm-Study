import java.io.*;
public class Main {
    static int m, n, k;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split(" ");

            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);

            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }

            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                arr[y][x] = 1;
            }
            int cnt = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }
    }
}
