import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                } else if (end == i) {
                    end--;
                    continue;
                }

                long sum = nums[start] + nums[end];

                if (sum == nums[i]) {
                    cnt++;
                    break;
                }

                if (sum < nums[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
