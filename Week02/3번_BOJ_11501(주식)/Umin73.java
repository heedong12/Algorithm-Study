import java.io.*;
import java.util.StringTokenizer;

public class _11501 {
    static int T, N;
    static int[] stockPriceArr;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            answer = 0L;
            N = Integer.parseInt(br.readLine());

            stockPriceArr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                stockPriceArr[j] = Integer.parseInt(st.nextToken());
            }

            int max = stockPriceArr[N-1];
            for(int j=N-2; j>=0; j--) {
                if(stockPriceArr[j] > max) {
                    max = stockPriceArr[j];
                }
                else {
                    answer += (max - stockPriceArr[j]);
                }
            }

            bw.write(String.valueOf(answer) + "\n");
        }

        br.close();
        bw.close();
    }
}
