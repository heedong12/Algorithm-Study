import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long n = Long.parseLong(input[0]);
        long l = Long.parseLong(input[1]);
        long w = Long.parseLong(input[2]);
        long h = Long.parseLong(input[3]);

        double start = 0, end = Math.min(l, Math.min(w, h));
        while (start < end) {
            double mid = (start + end) / 2;

            if (((long)(l / mid) * (long)(w / mid) * (long)(h / mid)) < n) {
                if (end == mid) {
                    break;
                }
                end = mid;
            } else {
                if (start == mid) {
                    break;
                }
                start = mid;
            }
        }

        System.out.println(start);
    }
}
