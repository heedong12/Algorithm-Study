package 백준;

import java.io.*;

public class _10971 {
    static int N;
    static int[][] W; // [i][j]: i도시에서 j도시로 가는데 드는 비용
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    static void solution(int depth, int next, int cost) {
        if(depth == N) {
            if(answer > cost) answer = cost;
            return;
        }

        if(depth == N-1) {
            if(W[next][0] == 0) return;
            solution(depth+1, 0, cost+W[next][0]);
        }

        for(int i = 1; i < N; i++) {
            if(!visited[i] && W[next][i] != 0) {
                visited[i] = true;
                solution(depth+1, i, cost+W[next][i]);
                visited[i] = false;
            }
        }
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                W[i][j] = Integer.parseInt(input[j]);
            }
        }

        solution(0, 0, 0);
        System.out.println(answer);

        br.close();
    }
}
