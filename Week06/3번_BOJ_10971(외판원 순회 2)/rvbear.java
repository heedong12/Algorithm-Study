import java.io.*;
import java.util.*;

public class Main {
    static int n, INF = 100000000;
    static int[][] map, dp;

    static int tsp(int cur, int visited) {
        if (visited == (1 << n) - 1) {
            if (map[cur][0] == 0) {
                return INF;
            } else {
                return map[cur][0];
            }
        }

        int result = dp[cur][visited];
        if (result != -1) {
            return result;
        }

        result = INF;

        for (int i = 0; i < n; i++) {
            if (map[cur][i] != 0 && (visited & 1 << i) == 0) {
                int temp = tsp(i, visited + (1 << i)) + map[cur][i];
                result = Math.min(temp, result);
            }
        }

        return dp[cur][visited] = result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0,1));
    }
}
