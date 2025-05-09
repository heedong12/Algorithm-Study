import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                long sum = arr[left] + arr[right];
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }

                if(sum == arr[i]) {
                    cnt++;
                    break;
                } else if(sum > arr[i]){
                    right--;
                }else {
                    left++;
                }
            }
        }

        System.out.println(cnt);
    }
}
