import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String[] input;

        while (t-- > 0) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[] arrA = new int[n];
            int[] arrB = new int[m];

            input = br.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");
            for(int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(arrB);
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int start = 0, end = m - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (arrB[mid] < arrA[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                cnt += start;
            }

            stb.append(cnt).append("\n");
        }

        System.out.println(stb.toString());
    }
}
