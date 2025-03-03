import java.io.*;
import java.util.*;

public class Main {

    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스
        while(T-- > 0){
            int k = Integer.parseInt(br.readLine()); //층
            int n = Integer.parseInt(br.readLine()); //호
            int[][] dp = new int[k+1][n+1];

            for(int i=1; i<=n; i++) {
                dp[0][i] = i;
            }

            for(int i=1; i<=k; i++) {
                for(int j=1; j<=n; j++) {
                    dp[i][j]= (dp[i-1][j] + dp[i][j-1]);
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
