import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][][] dp = new int[101][101][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int n = 2; n <= 100; n++) {
            for (int k = 0; k <= n; k++) {
                dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
                if (k > 0) {
                    dp[n][k][1] = dp[n - 1][k][0] + dp[n - 1][k - 1][1];
                } else {
                    dp[n][k][1] = dp[n - 1][k][0];
                }
            }
        }

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            System.out.println(dp[N][K][0] + dp[N][K][1]);
        }
    }
}
