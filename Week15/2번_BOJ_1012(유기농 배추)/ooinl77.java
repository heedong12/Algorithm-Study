import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, map, visited, N, M, dx, dy);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }

    public static void dfs(int y, int x, int[][] map, boolean[][] visited, int N, int M, int[] dx, int[] dy) {
        visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx, map, visited, N, M, dx, dy);
                }
            }
        }
    }
}
