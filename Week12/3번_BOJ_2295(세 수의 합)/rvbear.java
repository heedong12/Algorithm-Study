import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                for (int k = j; k >= 0; k--) {
                    int target = arr[i] - (arr[j] + arr[k]);

                    if (target <= 0) {
                        break;
                    }

                    if (Arrays.binarySearch(arr, target) >= 0) {
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
    }
}
