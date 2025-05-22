import java.io.*;

public class Main {
    static int t, m, n, k;
    static int[][] map;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < m && my >= 0 && my < n && map[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        String[] input;

        for (int i = 0; i < t; i++) {
            input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            map = new int[m][n];

            k = Integer.parseInt(input[2]);
            for (int j = 0; j < k; j++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                map[x][y] = 1;
            }

            count = 0;
            for (int r = 0; r < m; r++) {
                for (int s = 0; s < n; s++) {
                    if (map[r][s] == 1) {
                        dfs(r, s);
                        count++;
                    }
                }
            }

            stb.append(count).append("\n");
        }

        System.out.print(stb);
    }
}
