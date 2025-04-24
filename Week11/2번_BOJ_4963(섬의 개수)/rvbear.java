import java.io.*;
import java.util.*;

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    static void bfs(int[][] map, boolean[][] visit, int x, int y, int h, int w) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            int cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            boolean[][] visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        bfs(map, visit, i, j, h, w);
                        cnt++;
                    }
                }
            }

            stb.append(cnt).append("\n");
        }

        System.out.print(stb);
    }
}
