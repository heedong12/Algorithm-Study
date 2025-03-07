import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int MOD = 10007;
        int[][] dp = new int[N + 1][K + 1];

        
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1; // nC0 = 1
            for (int j = 1; j <= Math.min(i, K); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}