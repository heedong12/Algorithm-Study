import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int target = arr[i] - arr[j];
                if (set.contains(target)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
