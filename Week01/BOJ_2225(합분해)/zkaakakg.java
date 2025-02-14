import java.io.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String [] input  = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    long[][] dp = new long[k+1][n+1];

  
    for(int i = 0; i <= k; i ++){
      dp[i][0] = 1;
    }


    for(int i = 1; i <= k; i++){
      for(int j = 0; j <=n;j++){
        if(j==0) {dp[i][j] = 1;}
        else{dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;}
      }
    }
    System.out.println(dp[k][n]);

  }
}
