import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, C));
    }

    static long solution(int A, int B, int C) {
        if (B == 0) return 1;

        long a = solution(A, B / 2, C);
        long result =  a * a % C;

        if (B % 2 == 0) {
            return result;
        } else {
            return result * A % C;
        }
    }
}
