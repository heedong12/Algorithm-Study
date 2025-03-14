package 백준;

import java.io.*;

public class _1166 {
    static long N, L, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Long.parseLong(input[0]);
        L= Long.parseLong(input[1]);
        W = Long.parseLong(input[2]);
        H = Long.parseLong(input[3]);

        double first = 0;
        double last = Math.max(L, Math.max(W, H));

        while (first < last) {
            double mid = (first + last) / 2;

            if (last == mid || first == mid) break;

            if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) first = mid;
            else last = mid;
        }

        System.out.println(first);
        br.close();
    }
}
