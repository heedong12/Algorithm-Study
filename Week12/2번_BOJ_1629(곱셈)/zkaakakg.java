import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long c = Integer.parseInt(input[2]);
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % c;
            }
            a = (a * a) % c;
            b /= 2;
        }

        System.out.println(result);
    }

}
