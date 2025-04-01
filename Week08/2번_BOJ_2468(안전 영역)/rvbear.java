import java.io.*;
import java.util.*;

public class Main {
    static int n, max = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    public static void dfs(int x, int y, int num) {
        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny] >= num) {
                dfs(nx, ny, num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(!list.contains(map[i][j])) {
                    list.add(map[i][j]);
                }
            }
        }

        for(int num : list) {
            visit = new boolean[n][n];
            int count = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visit[i][j] && map[i][j] >= num) {
                        dfs(i, j, num);
                        count++;
                    }
                }
            }

            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}
