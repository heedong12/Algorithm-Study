import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 첫 번째 수
        int P = Integer.parseInt(st.nextToken()); // 자리 곱셈 수

        Map<Integer, Integer> map = new HashMap<>(); // <수열, 인덱스> 저장
        int index = 0;

        while (!map.containsKey(A)) {
            map.put(A, index++);

            // 다음 수열 계산
            int temp = A;
            int num = 0;
            while (temp > 0) {
                num += Math.pow(temp % 10, P);
                temp /= 10;
            }

            // 업데이트
            A = num;
        }

        System.out.println(map.get(A));

    }
}