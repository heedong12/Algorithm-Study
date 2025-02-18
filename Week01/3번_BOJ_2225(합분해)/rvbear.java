import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] dp = new long[N+1][K+1];
        for (long[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K] % MOD);
    }
}
