import java.io.*;
import java.util.*;

public class Main {
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int num = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] map = new int[n][n];
            int[][] dijk = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
                Arrays.fill(dijk[i], Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            pq.offer(new int[] {0, 0, map[0][0]});
            dijk[0][0] = map[0][0];

            while (!pq.isEmpty()) {
                int[] temp = pq.poll();
                int x = temp[0];
                int y = temp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + d[i][0];
                    int ny = y + d[i][1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && dijk[nx][ny] > (dijk[x][y] + map[nx][ny])) {
                        dijk[nx][ny] = dijk[x][y] + map[nx][ny];
                        pq.offer(new int[] {nx, ny, dijk[nx][ny]});
                    }
                }
            }

            stb.append("Problem ").append(num++).append(": ").append(dijk[n - 1][n - 1]).append("\n");
        }

        System.out.print(stb);
    }
}
