import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int N = Integer.parseInt(br.readLine()); //수열 크기
        int[] A = new int[N]; //수열
        int[] stack = new int[N]; //스택
        int[] result = new int[N]; //결과저장
        int top = -1; //스택 인덱스

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N-1; i >= 0; i--) {
            // 스택에서 현재 값보다 작거나 같은 수는 제외
            while (top >= 0 && stack[top] <= A[i]) {
                top--;
            }

            if (top == -1) {
                result[i] = -1;
            } else {
                result[i] = stack[top];
            }

            // 현재 값을 스택에 push
            stack[++top] = A[i];
        }

        sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
