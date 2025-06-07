package 백준;

import java.io.*;

public class _2698 {

    static int N, K;
    static int[][][] dp;
    static final int MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp = new int[MAX][MAX][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for(int n=2; n<MAX; n++) {
            for(int k=0; k<MAX; k++) {
                if(k > 0) {
                    dp[n][k][1] = dp[n-1][k-1][1] + dp[n-1][k][0];
                } else {
                    dp[n][k][1] = dp[n-1][k][0];
                }
                dp[n][k][0] = dp[n-1][k][0] + dp[n-1][k][1];
            }
        }

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            sb.append(dp[N][K][0] + dp[N][K][1]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
