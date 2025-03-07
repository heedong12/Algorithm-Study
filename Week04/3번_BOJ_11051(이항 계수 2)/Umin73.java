package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11051 {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[N+1][K+1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i=1;i<=N;i++) {
            for(int j=1; j<=K;j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
                }
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }
}
