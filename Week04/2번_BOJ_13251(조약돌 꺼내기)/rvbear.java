import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int total = 0;
        int[] color = new int[m];
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(input[i]);
            total += color[i];
        }

        int k = Integer.parseInt(br.readLine());

        if (m == 1 || k == 1) {
            System.out.println(1.0);
            return;
        }

        double mod = 1;
        for (int i = 0; i < k; i++) {
            mod *= (double) total - i;
        }

        double ans = 0;
        for (int i = 0; i < m; i++) {
            double temp = 1;
            for (int j = 0; j < k; j++) {
                temp *= (double) color[i] - j;
            }
            ans += temp / mod;
        }

        System.out.println(ans);
    }
}
