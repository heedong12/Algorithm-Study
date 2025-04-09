import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        long[] lines = new long[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
            if (max < lines[i]) {
                max = lines[i];
            }
        }

        long min = 1;
        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += lines[i] / mid;
            }

            if (cnt < n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println((min + max) / 2);
    }
}
