import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 1001;
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) continue;
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[n - 1] == max ? -1 : dp[n - 1]);
    }
}
