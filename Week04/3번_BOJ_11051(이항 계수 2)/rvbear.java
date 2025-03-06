import java.io.*;
import java.util.*;

public class Main {
    static int mod = 10007;
    static long[][] dp;

    static long combination(int n, int k) {
        if(dp[n][k] > 0) {
            return dp[n][k];
        }

        if(k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (combination(n - 1, k - 1) + combination(n - 1, k)) % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        k = (n / 2 + 1) < k ? n - k : k;
        dp = new long[n + 1][k + 1];

        System.out.println(combination(n, k));
    }
}
