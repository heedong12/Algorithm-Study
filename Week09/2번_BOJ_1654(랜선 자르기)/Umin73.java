package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1654 {
    static int K;
    static long N;
    static long[] lanCables;
    static long maxLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Long.parseLong(input[1]);

        lanCables = new long[K];
        for(int i=0; i<K; i++) {
            lanCables[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(maxLength, lanCables[i]);
        }

        long answer = 0;
        long left = 1;
        long right = maxLength;
        while(left <= right) {
            long mid = (left + right)/2;
            long cnt = 0;

            for(long lan : lanCables) {
                cnt += lan / mid;
            }

            if(cnt >= N) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
        br.close();
    }

}
