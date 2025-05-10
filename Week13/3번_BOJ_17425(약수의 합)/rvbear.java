import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        long[] n = new long[1000001];

        for (int i = 1; i < n.length; i++) {
            for (int j = i; j < n.length; j += i) {
                n[j] += i;
            }
        }

        for (int i = 2; i < n.length; i++) {
            n[i] += n[i - 1];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int target = Integer.parseInt(br.readLine());
            stb.append(n[target]).append("\n");
        }

        System.out.print(stb);
    }
}
