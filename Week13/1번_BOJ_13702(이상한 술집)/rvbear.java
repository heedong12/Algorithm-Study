import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        long[] kettles = new long[n];
        long end = 0;
        for (int i = 0; i < n; i++) {
            kettles[i] = Long.parseLong(br.readLine());
            end = Math.max(end, kettles[i]);
        }

        long start = 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;

            for (long kettle : kettles) {
                cnt += (int) (kettle / mid);
            }

            if (cnt >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
