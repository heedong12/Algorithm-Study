package 백준;

import java.io.*;

public class _2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 1;

    // K는 물에 잠기는 높이의 기준
    static void dfs(int I, int J, int K) {
        if(I > 0 && J > 0 && I <= N && J <= N) {
            if(visited[I][J]) return;

            if(map[I][J] > K) {
                visited[I][J] = true;

                dfs(I-1, J, K);
                dfs(I+1, J, K);
                dfs(I, J-1, K);
                dfs(I, J+1, K);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2];
        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        // 일단 5이하만 잠긴다고 가정하기
        for(int k=1; k<=100; k++) {
            int areaCnt = 0;
            visited = new boolean[N+2][N+2];
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(!visited[i][j] && map[i][j] > k) {
                        areaCnt++;
                        dfs(i, j, k);
                    }
                }
            }
            answer = Math.max(areaCnt, answer);
        }

        System.out.println(answer);
        br.close();
    }
}
