
import java.io.*;

public class _2748 {

    static int N;
    static Long[] fiboArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        fiboArr = new Long[N+1];
        fiboArr[0]= 0L;
        fiboArr[1]= 1L;

        for(int i=2;i<=N;i++) {
            fiboArr[i] = fiboArr[i-1]+fiboArr[i-2];
        }

        bw.write(String.valueOf(fiboArr[N]));
        bw.flush();

        br.close();
        bw.close();
    }
}