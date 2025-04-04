import java.io.*;
import java.util.*;

public class Main {
    static int n, temp;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < n && my < n && !visit[mx][my] && map[mx][my] == 1) {
                temp++;
                dfs(mx, my);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        temp = 0;
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    temp = 1;
                    dfs(i, j);
                    size.add(temp);
                }
            }
        }

        Collections.sort(size);

        stb.append(size.size()).append("\n");
        for (int num : size) {
            stb.append(num).append("\n");
        }

        System.out.print(stb.toString());
    }
}
