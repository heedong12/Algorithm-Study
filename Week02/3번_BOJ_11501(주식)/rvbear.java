import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            int[] val = new int[N];

            for (int i = 0; i < N; i++) {
                val[i] = Integer.parseInt(temp[i]);
            }

            int max = val[N-1];
            long res = 0;

            for (int i = N-2; i > -1; i--) {
                if (val[i] > max) {
                    max = val[i];
                } else {
                    res += max - val[i];
                }
            }

            bw.write(res + "\n");
        }

        br.close();
        bw.close();
    }
}
