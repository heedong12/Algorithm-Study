import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static String[] titles;
    static int[] powers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        titles = new String[n];
        powers = new int[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            titles[i] = input[0];
            powers[i] = Integer.parseInt(input[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(solution(power)).append('\n');
        }
        System.out.print(sb);
    }

    static public String solution(int power) {
        int left = 0;
        int right = n - 1;
        String result = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (power <= powers[mid]) {
                result = titles[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }
}
