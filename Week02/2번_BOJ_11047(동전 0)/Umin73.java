import java.io.*;
import java.util.StringTokenizer;

public class _11047 {

    static int N, K;
    static int[] coinArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coinArr = new int[N];
        for (int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        int cnt =0;
        for(int i = N-1; i>=0; i--) {
            if(K / coinArr[i] > 0) {
                cnt += (K / coinArr[i]);
                K -= (K / coinArr[i]) * coinArr[i];
            }
        }

        bw.write(String.valueOf(cnt));

        br.close();
        bw.close();
    }
}
