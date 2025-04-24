import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int W;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            int[][] map = new int[H][W];
            boolean[][] visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(j, i, map, visited);
                        island++;
                    }
                }
            }

            System.out.println(island);

        }


    }

    static void dfs(int w, int h, int[][] map, boolean[][] visited) {
        // 바다
        if(w<0 || h<0 || w>=W || h>=H || map[h][w] == 0) return;
        // 왔다감
        if(visited[h][w] ) return;

        visited[h][w] = true;

        //상하좌우, 대각선 탐색
        dfs(w+1, h, map, visited);
        dfs(w+1, h+1, map, visited);
        dfs(w+1, h-1, map, visited);
        dfs(w-1, h, map, visited);
        dfs(w-1, h+1, map, visited);
        dfs(w-1, h-1, map, visited);
        dfs(w, h+1, map, visited);
        dfs(w, h-1, map, visited);
    }
}
