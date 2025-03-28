import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 용액 수
        int[] solution = new int[N]; // 용액 특성 값
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int left = 0;
        int right = N-1;
        int compare = Integer.MAX_VALUE; // 비교 숫자
        int[] result = new int[2]; // 결과 저장
        while (left < right) {
            int sum = solution[left] + solution[right];

            // 절대값이 작으면 0과 가까움
            if (Math.abs(sum) < compare) {
                compare = Math.abs(sum);
                result[0] = solution[left];
                result[1] = solution[right];
            }
            if (sum > 0) {
                right --;
            } else {
                left ++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}