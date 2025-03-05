import java.io.*;
import java.util.*;


public class Main {
    public static double sequence(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;

        double result = 1;
        //조합 계산
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); // 색상 수
        int[] colors = new int[M]; // 색상 별 돌 개수 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0; // 모든 돌의 수
        for(int i=0; i<M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            count += colors[i];
        }
        int K = Integer.parseInt(br.readLine()); // 뽑기 수

        double allCase = sequence(count, K); // 전체 뽑기 수
        double answerCase = 0; // 조건 뽑기 수
        for(int color: colors) {
            answerCase += sequence(color, K);
        }

        System.out.println(answerCase/allCase);
    }
}
