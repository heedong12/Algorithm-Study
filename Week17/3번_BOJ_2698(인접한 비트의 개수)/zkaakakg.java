import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][][] dp;

        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            dp = new int[101][101][2];
            dp[1][0][0] = dp[1][0][1] = 1;

            for (int i = 2; i <= n ; i++) {
                for (int j = 0; j <=k ; j++) {
                    dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
                    if(j == 0){
                        dp[i][j][1] = dp[i-1][j][0];
                    }else{
                        dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j-1][1];
                    }
                }
            }

            int result = dp[n][k][0] + dp[n][k][1];
            System.out.println(result);
        }
    }
}
