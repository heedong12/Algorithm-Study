import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[n + 1];
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        String[] input = br.readLine().split(" ");
        int idx = 0;
        int question = Integer.parseInt(input[idx++]);

        if (question == 1) {
            long k = Long.parseLong(input[idx++]);

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (visit[j]) {
                        continue;
                    }

                    if (factorial[n - i - 1] < k) {
                        k -= factorial[n - i - 1];
                    } else {
                        stb.append(j).append(" ");
                        visit[j] = true;
                        break;
                    }
                }
            }
        } else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[idx++]);
            }

            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (visit[j]) {
                        continue;
                    }

                    ans += factorial[n - i - 1];
                }
                visit[arr[i]] = true;
            }

            stb.append(ans);
        }

        System.out.println(stb.toString());
    }
}
