
import java.io.*;
import java.util.StringTokenizer;

public class _4796 {

    static int L, P, V;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int caseCnt = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            // V%P < L인 경우도 고려해야함
            answer = ((V/P)*L) + Math.min((V%P), L);

            bw.write("Case " + caseCnt + ": ");
            bw.write(String.valueOf(answer));
            bw.write("\n");

            caseCnt++;
        }

        bw.close();
        br.close();
    }
}
