import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = Long.parseLong(input[2]);

        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * a % c;
            }
            a = a * a % c;
            b /= 2;
        }

        System.out.println(res);
    }
}
