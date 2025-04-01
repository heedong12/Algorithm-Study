import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 땅 크기
        int[][] height = new int[N][N]; // 땅 높이
        int maxCount = 0; // 최대 영역 수
        int maxHeight = 0; // 가장 높은 땅
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int currentHeight = Integer.parseInt(st.nextToken());
                height[i][j] = currentHeight;
                maxHeight = Math.max(currentHeight, maxHeight);
            }
        }

        for (int i=0; i<maxHeight; i++) { // i = 물 높이
            boolean[][] visited = new boolean[N][N];
            int count = 0; // 현재 영역 수
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if(visited[j][k]) continue;
                    if(height[j][k] <= i) continue;
                    dfs(j, k, height, visited, i, N);
                    count++;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }

    public static void dfs (int currentHeight, int currentWidth, int[][] height, boolean[][] visited, int targetHeight, int N ) {
        // index 0 미만, 크기 초과 거르기
        if(currentHeight < 0 || currentHeight >= N) return;
        if(currentWidth < 0 || currentWidth >= N) return;
        // 물에 잠김
        if(height[currentHeight][currentWidth] <= targetHeight) return;
        // 안잠김
        if(visited[currentHeight][currentWidth]) return;
        // 왔다감
        visited[currentHeight][currentWidth] = true;
        //앞 뒤 양 옆 조사
        dfs(currentHeight + 1, currentWidth, height, visited, targetHeight, N);
        dfs(currentHeight - 1 , currentWidth, height, visited, targetHeight, N);
        dfs(currentHeight, currentWidth + 1, height, visited, targetHeight, N);
        dfs(currentHeight, currentWidth - 1 , height, visited, targetHeight, N);
    }
}