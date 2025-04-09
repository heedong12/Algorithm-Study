import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); //랜선개수
        int N = Integer.parseInt(st.nextToken()); //필요랜선개수
        int[] length = new int[K]; //랜선길이
        long maxLength = 0;//랜선최대길이
        for (int i = 0; i < K; i++) {
            length[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, length[i]);
        }

        long start = 1; //최소길이
        long end = maxLength; //최대길이
        long result = 0; //만들수있는최대길이

        while (start <= end) {
            long mid = (start + end) / 2; //중간길이
            long count = 0; //개수

            //랜선개수구해서
            for (int i = 0; i < K; i++) {
                count += length[i] / mid;
            }

            //N보다 크면 가능함
            //더 긴 길이 확인
            if (count >= N) {
                result = mid;
                start = mid + 1;
            } else {
                //불가능
                //더 짧은 길이 확인
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
