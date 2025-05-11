import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            int target = num[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = num[left] + num[right];

                if (sum == target) {
                    result++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(result);
    }
}
