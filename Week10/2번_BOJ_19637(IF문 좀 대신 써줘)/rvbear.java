import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] names = new String[n];
        long[] fights = new long[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            names[i] = input[0];
            fights[i] = Long.parseLong(input[1]);
        }

        for (int i = 0; i < m; i++) {
            long value = Long.parseLong(br.readLine());
            int start = 0, end = n;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (value <= fights[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            stb.append(names[start]).append("\n");
        }

        System.out.print(stb);
    }
}
