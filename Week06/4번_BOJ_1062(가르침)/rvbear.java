import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max = Integer.MIN_VALUE;
    static boolean[] visit = { true, false, true, false, false, false, false, false, true, false, false, false, false,
                            true, false, false, false, false, false, true, false, false, false, false, false, false};
    static String[] word;

    static void backtracking(int alphabet, int len) {
        if (len == k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visit[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        for (int i = alphabet; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                backtracking(i, len + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken()) - 5;

        if (k < 0) {
            System.out.println(0);
            return;
        } else if (k == 21) {
            System.out.println(n);
            return;
        }

        word = new String[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            String temp = stk.nextToken();
            word[i] = temp.substring(4, temp.length() - 4);
        }

        backtracking(0, 0);

        System.out.println(max);
    }
}
