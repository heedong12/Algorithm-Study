import java.io.*;
import java.util.StringTokenizer;

public class _2225 {

    static int N, K;
    static int answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[201][201];
        for(int i=1; i<=K; i++) {
            arr[i][0] = 1;
        }

        for(int i=1; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000000;
            }
        }

        bw.write(String.valueOf(arr[K][N]));
        bw.flush();

        br.close();
        bw.close();

    }
}