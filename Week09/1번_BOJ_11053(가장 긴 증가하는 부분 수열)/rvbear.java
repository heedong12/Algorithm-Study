import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N + 1];
        long[] DP = new long[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            numbers[i] = Long.parseLong(input[i - 1]);
            DP[i] = 1;
        }

        long max = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            
            max = Math.max(max, DP[i]);
        }

        System.out.println(max);
    }
}
