import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String N = br.readLine();
        char[] ch = N.toCharArray();

        int sum = 0;
        boolean hasZero = false;

        for (char c : ch) {
            int d = c - '0';
            sum += d;
            if (d == 0) hasZero = true;
        }

        // 조건 체크: 0 포함 + 자릿수 합이 3의 배수
        if (!hasZero || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        // 내림차순 정렬
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder(new String(ch));
        System.out.println(sb.reverse());

    }
}
