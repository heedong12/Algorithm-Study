import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] num = new int[T + 1];
        int max = 0; // 케이스 최대 값
        for (int i=1; i<=T; i++) {
            int n = Integer.parseInt(br.readLine());
            num[i] = n;
            max = Math.max(max, n);
        }

        long[] fx = new long[max + 1]; //약수의 합
        long[] gx = new long[max + 1]; //누적 합

        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                fx[j] += i;
            }
        }

        for (int i = 1; i <= max; i++) {
            gx[i] = gx[i - 1] + fx[i];
        }

        for (int i = 1; i <= T; i++) {
            sb.append(gx[num[i]]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
