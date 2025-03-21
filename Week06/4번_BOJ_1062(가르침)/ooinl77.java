import java.io.*;
import java.util.*;

public class Main {

    static int N;  // 단어 수
    static int K; // 글자 수
    static String S = "antic"; // 고정단어
    static String[] word; // 단어모음
    static boolean[] used = new boolean[26]; // 알파벳 기록?
    //    static boolean[] history; // 단어 사용?
    static int maxCount = 0; // 최대 단어 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 고정 글자 수 보다 작으면 자격 미달.
        if (K < 5) {
            System.out.println(0);
            return;
        }
        // 고정 글자 수 만큼 빼기, 배열 갱신
        K -= 5;
        used['a' - 'a'] = true;
        used['n' - 'a'] = true;
        used['t' - 'a'] = true;
        used['i' - 'a'] = true;
        used['c' - 'a'] = true;

        word = new String[N];
//        history = new boolean[N];

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        dfs(0, K);

        System.out.println(maxCount);

    }

    public static void dfs(int start, int K) {
        //알파벳 조합 완성되면 단어검사
        if (K == 0) {
            int count = 0;
            //알파벳 배열에 없는 문자 검거
            for (String w : word) {
                boolean learn = true; // 검거 flag
                for (char c : w.toCharArray()) {
                    if (!used[c - 'a']) {
                        learn = false;
                        break;
                    }
                }
                if (learn) count++;
            }
            maxCount = Math.max(maxCount, count);
            return;
        }

        // 알파벳 조합
        for (int i = start; i < 26; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(i + 1, K - 1);
                used[i] = false;
            }
        }
    }
}
