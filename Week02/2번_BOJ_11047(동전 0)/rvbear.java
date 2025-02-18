import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Long.parseLong(input[1]);
        long[] coins = new long[N];
        int idx = 0;

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());

            if (coins[i] <= K) {
                idx = i;
            }
        }

        int cnt = 0;

        for (int i = idx; i >= 0; i--) {
            cnt += (int) (K / coins[i]);
            K %= coins[i];

            if (K == 0) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
