import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine()); //퇴사일
        int[] T = new int[N + 1]; //상담기간
        int[] P = new int[N + 1]; //금액
        int[] dp = new int[N + 2]; //날짜 별 최대금액 저장

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 상담 안하면 그 전 최대값을 유지
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // 퇴사 전에 상담 가능하면 끝나는 날 수익
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        // 최대 이익 계산
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
