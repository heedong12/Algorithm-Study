import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        long m = Long.parseLong(stk.nextToken());
        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = 0;
        long sum = 0, cnt = 0;
        while (end < n) {
            sum += arr[end++];

            while (sum > m && start < end) {
                sum -= arr[start++];
            }

            if (sum == m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
