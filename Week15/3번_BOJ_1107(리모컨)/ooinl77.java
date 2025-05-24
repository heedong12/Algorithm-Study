import java.io.*;
import java.util.*;

public class Main {

    public static int canPress(int num, boolean[] broken) {
        if (num == 0) return broken[0] ? -1 : 1;

        int len = 0;
        while (num > 0) {
            if (broken[num % 10]) return -1;
            num /= 10;
            len++;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 목표 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 수

        boolean[] broken = new boolean[10]; // 고장 버튼
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        int minClick = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            int len = canPress(i, broken); // 자리수
            if (len > 0) {
                int press = len + Math.abs(N - i); // 클릭수
                minClick = Math.min(minClick, press);
            }
        }

        System.out.println(minClick);
    }
}
