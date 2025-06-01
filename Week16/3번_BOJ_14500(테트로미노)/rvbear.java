import java.io.*;

public class Main {
    static int max = 0, n, m;
    static int[][] map, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;

    static void dfs(int row, int col, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue;
            }

            if (!visit[nextRow][nextCol]) {
                if (depth == 2) {
                    visit[nextRow][nextCol] = true;
                    dfs(row, col, sum + map[nextRow][nextCol], depth + 1);
                    visit[nextRow][nextCol] = false;
                }

                visit[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, sum + map[nextRow][nextCol], depth + 1);
                visit[nextRow][nextCol] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }
}
