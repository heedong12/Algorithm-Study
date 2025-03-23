package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1062 {
    static int N, K;
    static String[] words;
    static int alphabetMask = 0;
    static int answer = 0;

    static void solution(int depth, int start) {
        if(depth == K-5) {
            int tempCnt = readWordCnt();
            answer = Math.max(answer, tempCnt);
            return;
        }

        for (int i=start; i<26; i++) {
            if ((alphabetMask & (1 << i)) != 0) continue;
            alphabetMask |= (1 << i);
            solution(depth+1, i+1);
            alphabetMask &= ~(1 << i);
        }
    }

    static int readWordCnt() {
        int canRead = 0;
        boolean flag;
        for (String word : words) {
            flag = true;
            for (char c:word.toCharArray()) {
                if ((alphabetMask & (1 << (c-'a'))) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) canRead++;
        }
        return canRead;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if(K < 5) {
            System.out.println(0);
            br.close();
            return;
        }

        words = new String[N];
        alphabetMask |= (1 << ('a' - 'a'));
        alphabetMask |= (1 << ('n' - 'a'));
        alphabetMask |= (1 << ('t' - 'a'));
        alphabetMask |= (1 << ('i' - 'a'));
        alphabetMask |= (1 << ('c' - 'a'));

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            if(word.length() > 8) {
                words[i] = word.substring(4, word.length()-4);
            } else {
                words[i] = "";
            }
        }

        solution(0,0);

        System.out.println(answer);
        br.close();
    }
}
