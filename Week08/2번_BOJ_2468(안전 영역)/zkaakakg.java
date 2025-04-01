import java.io.*;
public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int min = 100;
        int max = 1;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int result = 1;
        for (int i = min; i < max; i++) {
            visited = new boolean[n][n];
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && arr[j][k] > i){
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            result = Math.max(result,cnt);
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y, int h){
       visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && arr[nx][ny] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}
