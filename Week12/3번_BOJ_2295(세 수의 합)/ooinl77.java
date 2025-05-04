import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();

        // 두 수의 합
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        // 큰 수부터 시작
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int diff = arr[i] - arr[j];
                if (set.contains(diff)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
