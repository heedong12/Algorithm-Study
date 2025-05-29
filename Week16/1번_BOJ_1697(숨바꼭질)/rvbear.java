import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] dp = new int[100100];

        for (int i = 0; i < n; i++) {
            dp[i] = n - i;
        }

        for (int i = n + 1; i <= k; i++) {
            int min;

            if (i % 2 == 0) {
                min = dp[i / 2] + 1;
            } else {
                min = Math.min(dp[(i + 1) / 2], dp[(i - 1) / 2]) + 2;
            }

            dp[i] = Math.min(min, dp[i - 1] + 1);
        }

        System.out.println(dp[k]);
    }
}
