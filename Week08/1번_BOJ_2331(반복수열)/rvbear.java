import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        int p = Integer.parseInt(input[1]);
        List<Long> arr = new ArrayList<>();
        arr.add(a);

        while (true) {
            long temp = arr.get(arr.size() - 1);
            long target = 0;

            while (temp > 0) {
                target += (long)Math.pow(temp % 10, p);
                temp /= 10;
            }

            if (arr.contains(target)) {
                System.out.println(arr.indexOf(target));
                break;
            }

            arr.add(target);
        }
    }
}
