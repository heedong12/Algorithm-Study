package 백준;

import java.io.*;
public class _1012_2 {

    static int M, N, K;
    static boolean[][] arr;
    static int answer;

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static void dfs(int y, int x) {
        arr[y][x] = false;

        for(int i=0; i<4; i++) {
            int nextX = x + dir[i][1];
            int nextY = y + dir[i][0];

            if(arr[nextY][nextX]) dfs(nextY, nextX);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            answer = 0;
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            arr = new boolean[N+2][M+2];

            for(int i=0; i<K;i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                arr[y+1][x+1] = true;
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    if(arr[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
