import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine()); // 지도 크기, 0이면 종료
            if (N == 0) break;

            int[][] map = new int[N][N]; // 지도
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int result = bfs(map, N);
            System.out.println("Problem " + caseNum + ": " + result);
            caseNum++;
        }
    }


    static int bfs(int[][] map, int N) {
        int maxValue = Integer.MAX_VALUE;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 우선순위 큐 (min-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 비용 배열 최대로 초기화
        int[][] costMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(costMap[i], maxValue);
        }


        costMap[0][0] = map[0][0];
        pq.add(new int[]{0, 0, map[0][0]});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            // 목표 지점에 도달하면 그 즉시 반환
            if (x == N - 1 && y == N - 1) {
                return cost;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = cost + map[nx][ny];
                    if (newCost < costMap[nx][ny]) {
                        costMap[nx][ny] = newCost;
                        pq.add(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
