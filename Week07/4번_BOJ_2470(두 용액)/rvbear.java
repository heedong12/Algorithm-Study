import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE, ansLeft = 0, ansRight = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            long temp = arr[left] + arr[right];

            if (Math.abs(temp) < min) {
                min = Math.abs(temp);
                ansLeft = arr[left];
                ansRight = arr[right];
            }

            if (temp < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ansLeft + " " + ansRight);
    }
}
