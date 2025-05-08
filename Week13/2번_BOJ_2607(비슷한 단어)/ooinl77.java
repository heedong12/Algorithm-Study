import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 1; //단어 수 - 1
        int[] targetAlphabet = new int[26]; // 타겟 단어 구성
        int targetLength = 0; // 타겟 단어 길이
        int result = 0;

        for(char c : br.readLine().toCharArray()) {
            targetAlphabet[c - 'A'] ++;
            targetLength++;
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int[] wordAlphabet = new int[26];

            for (char c : word.toCharArray()) {
                wordAlphabet[c - 'A']++;
            }

            int diffCount = 0;
            for (int j = 0; j < 26; j++) {
                diffCount += Math.abs(targetAlphabet[j] - wordAlphabet[j]);
            }

            // 0 == 구성이 같은 단어
            // 1 == 문자 하나 넣거나 빼야 하는 단어
            // 2이고, 길이가 같으면 문자 하나를 바꾸면 되는 단어
            if (diffCount == 0 || diffCount == 1 || (diffCount == 2 && word.length() == targetLength)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
