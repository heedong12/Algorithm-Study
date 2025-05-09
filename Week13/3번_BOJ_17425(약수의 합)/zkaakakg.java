import java.io.*;

public class Main {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] f = new long[MAX + 1];
        long[] g = new long[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                f[j] += i;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            g[i] = g[i - 1] + f[i];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(g[n]).append('\n');
        }
        System.out.println(sb);
    }
}
