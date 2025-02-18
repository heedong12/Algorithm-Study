import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            stb.append(dp[n]).append("\n");
        }
        
        System.out.println(stb.toString());
    }
}
