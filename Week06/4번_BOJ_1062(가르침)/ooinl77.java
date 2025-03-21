import java.io.*;

import java.util.*;

public class Main {

    static int N;  // 도시 수
    static int[][] W; //비용
    static boolean[] visited; // 기록
    static int minCost = Integer.MAX_VALUE; //최소비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(0, 0, 0, 1);
        System.out.println(minCost);
    }

    //시작, 지금위치, 누적비용, 방문도시수
    public static void dfs(int start, int now, int cost, int count) {

        // 방문도시수가 도시수랑 같으면 끝?
        if (count == N) {
            if (W[now][start] > 0) {  // 집에 갈 수 있다.
                cost += W[now][start];
                minCost = Math.min(minCost, cost);  // 여행 경비 갱신
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (W[now][i] > 0 && !visited[i]) { // 길이 있고 간 적 없음
                visited[i] = true;  // 왔다감
                dfs(start, i, cost + W[now][i], count + 1);
                visited[i] = false;  // 취소
            }
        }
    }
}