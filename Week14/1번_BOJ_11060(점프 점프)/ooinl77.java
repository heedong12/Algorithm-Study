import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] jump = new int[N];
        int jumpCount = 0; // 점프 수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽 끝
        if (N == 1) {
            System.out.println(0);
            return;
        }
        // 점프 불가능
        if (jump[0] == 0) {
            System.out.println(-1);
            return;
        }

        int jumpIndex = 0; // 점프 후 인덱스
        int superJump = 0; // 점프 범위 중 가장 멀리 뛰기

        for (int i = 0; i < N; i++) {
            superJump = Math.max(superJump, i + jump[i]);

            // 점프
            if (i == jumpIndex) {
                jumpCount++;
                jumpIndex = superJump; // 점프 후 위치 갱신
                // 끝
                if (jumpIndex >= N - 1) {
                    System.out.println(jumpCount);
                    break;
                }
                // 점프 불가능
                if (jumpIndex <= i) {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
