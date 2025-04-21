import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        List<String> nums = new ArrayList<>();

        int sum = 0;
        boolean hasZero = false;
        for (int i = 0; i < n.length(); i++) {
            nums.add(String.valueOf(n.charAt(i)));
            int digit = n.charAt(i) - '0';
            sum += digit;
            if (digit == 0) hasZero = true;
        }
        if (hasZero && sum % 3 == 0) {
            nums.sort((a, b) -> Integer.parseInt(b) - Integer.parseInt(a));
            StringBuilder sb = new StringBuilder();
            for (String num : nums) {
                sb.append(num);
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
