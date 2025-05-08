import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int[] firstCnt = new int[26];

        for (char c : words[0].toCharArray()) {
            firstCnt[c - 'A']++;
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int[] curCnt = new int[26];
            for (char c : words[i].toCharArray()) {
                curCnt[c - 'A']++;
            }

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(firstCnt[j] - curCnt[j]);
            }
            if (diff <= 1) {
                cnt++;
            } else if (diff == 2 && words[0].length() == words[i].length()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
