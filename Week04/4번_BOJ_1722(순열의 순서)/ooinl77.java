import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[N + 1]; // 1부터 N까지 숫자 사용 여부
        long[] fact = new long[N + 1]; //  팩토리얼, 개수 계산용
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i;
        }

        if (T == 1) {
            long K = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) { // 자리수
                for (int j = 1; j <= N; j++) { // 숫자
                    if (used[j]) continue;
                    if (K > fact[N - i]) {
                        K -= fact[N - i];
                    } else {
                        used[j] = true;
                        sb.append(j).append(" ");
                        break;
                    }
                }
            }

        } else {
            int[] K = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                K[i] = Integer.parseInt(st.nextToken());
            }

            long result = 1;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j < K[i]; j++) {
                    if (used[j]) continue;
                    result += fact[N - i];
                }
                used[K[i]] = true;
            }
            sb.append(result);
        }
        System.out.println(sb.toString());
    }
}
