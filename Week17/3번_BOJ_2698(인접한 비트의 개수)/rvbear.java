import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[][][] dp = new int[101][101][2];
        dp[1][0][1] = dp[1][0][0] = 1;

        for (int i = 0; i < 101; i++) {
            for (int j = 2; j < 101; j++) {
                dp[j][i][1] += dp[j - 1][i][0];

                if (i != 0) {
                    dp[j][i][1] += dp[j - 1][i - 1][1];
                }
                
                dp[j][i][0] += dp[j - 1][i][0] + dp[j - 1][i][1];
            }
        }

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            stb.append(dp[n][k][0] + dp[n][k][1]).append("\n");
        }

        System.out.print(stb);
    }
}
