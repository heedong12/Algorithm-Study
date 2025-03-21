import java.io.*;
import java.util.*;
public class Main {
	static int n;
    static int[][] w;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            back(i, i, 0, 1);  // (시작 도시, 현재 도시, 비용, 방문한 개수)
        }
		
		System.out.println(minCost);
		
	}
	
	static void back(int start, int cur, int cost, int count) {
		// 현재까지 비용이 최소 비용보다 크면 중단
        if (cost >= minCost) return;
        
        // 모든 도시 방문 후, 시작점으로 돌아갈 수 있는 경우
        if (count == n) {
            if (w[cur][start] != 0) {
                minCost = Math.min(minCost, cost + w[cur][start]);
            }
            return;
        }
        
        // 모든 도시 탐색
        for (int ㅑ = 0; ㅑ < n; ㅑ++) {
            if (!visited[ㅑ] && w[cur][ㅑ] != 0) {
                visited[ㅑ] = true;
                back(start, ㅑ, cost + w[cur][ㅑ], count + 1);
                visited[ㅑ] = false; // 백트래킹
            }
        }
        
	}

}
