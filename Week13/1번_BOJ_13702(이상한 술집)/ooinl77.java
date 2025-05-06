import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 술
        int M = Integer.parseInt(st.nextToken());  // 친구

        long[] L = new long[N];
        long maxL = 0; // 가장 큰 통

        // 술통 용량 입력
        for (int i = 0; i < N; i++) {
            L[i] = Long.parseLong(br.readLine());
            if (L[i] > maxL) {
                maxL = L[i];
            }
        }

        long left = 1;
        long right = maxL;
        long result = 0;

        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                count += L[i] / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
