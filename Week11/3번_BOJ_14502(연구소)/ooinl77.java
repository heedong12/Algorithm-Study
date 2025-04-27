import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static List<int[]> safeArea;
    static List<int[]> virusArea;
    static int maxSafeArea = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        safeArea = new ArrayList<>();
        virusArea = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) safeArea.add(new int[]{i, j});
                if (map[i][j] == 2) virusArea.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < safeArea.size() - 2; i++) {
            for (int j = i + 1; j < safeArea.size() - 1; j++) {
                for (int k = j + 1; k < safeArea.size(); k++) {
                    int[] wall1 = safeArea.get(i);
                    int[] wall2 = safeArea.get(j);
                    int[] wall3 = safeArea.get(k);

                    // 벽 세우기
                    map[wall1[0]][wall1[1]] = 1;
                    map[wall2[0]][wall2[1]] = 1;
                    map[wall3[0]][wall3[1]] = 1;

                    // 바이러스 확산 및 안전 영역 계산
                    bfs();

                    // 벽 복구
                    map[wall1[0]][wall1[1]] = 0;
                    map[wall2[0]][wall2[1]] = 0;
                    map[wall3[0]][wall3[1]] = 0;
                }
            }
        }

        System.out.println(maxSafeArea);

    }

    static void bfs() {
        Queue<int[]> virusQ = new LinkedList<>();
        visited = new boolean[N + 2][M + 2];
        int virusCount = 0; // 감염된 구역 수

        for (int[] virus : virusArea) {
            virusQ.offer(virus);
            visited[virus[0]][virus[1]] = true;
        }

        while (!virusQ.isEmpty()) {
            int[] pos = virusQ.poll();
            for (int i = 0; i < 4; i++) {
                int x = pos[1] + dx[i];
                int y = pos[0] + dy[i];

                if (x > 0 && x <= M && y > 0 && y <= N && !visited[y][x] && map[y][x] == 0) {
                    visited[y][x] = true;
                    virusCount++;
                    virusQ.offer(new int[]{y, x});
                }
            }
        }

        int safe = safeArea.size() - virusCount - 3;
        maxSafeArea = Math.max(safe, maxSafeArea);
    }
}
