package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4963 {

    static int W, H;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dirX = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dirY = {0, 1, 0, -1, 1, -1, 1, -1};
    static void dfs(int curX, int curY) {
        visited[curY][curX] = true;

        for(int i=0; i<8; i++) {
            int nextX = curX + dirX[i];
            int nextY = curY + dirY[i];
            if(nextX >=0 && nextX < W && nextY >=0 && nextY < H) {
                if(!visited[nextY][nextX] && arr[nextY][nextX] == 1) dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        while(W != 0 && H != 0) {
            arr = new int[H][W];
            visited = new boolean[H][W];

            for(int i=0; i<H; i++) {
                input = br.readLine().split(" ");
                for(int j=0; j<W; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            int answer = 0;
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(!visited[i][j] && arr[i][j] == 1) {
                        dfs(j, i);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");

            input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);
        }

        System.out.println(sb);

        br.close();
    }
}
