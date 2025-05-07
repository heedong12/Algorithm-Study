package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2607 {

    static int N; // 단어의 개수
    static String firstWord;
    static int[] alphaCntArr;
    static int answer = 0;

    static int isSame(int[] curWorldAlphaCntArr) {
        int diffCnt = 0;
        for(int i=0; i<26; i++) {
            if(Math.abs(curWorldAlphaCntArr[i] - alphaCntArr[i]) == 1) diffCnt++;
            else if(Math.abs(curWorldAlphaCntArr[i] - alphaCntArr[i]) >= 2) {
                diffCnt = 999;
                return diffCnt;
            }
        }
        return diffCnt;
    }

    static void solution(String word) {
        int[] curWordAlphaCntArr = new int[26];

        for(char c: word.toCharArray()) {
            curWordAlphaCntArr[c - 'A']++;
        }

        if(isSame(curWordAlphaCntArr) <= 2) answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        firstWord = br.readLine();

        alphaCntArr = new int[26];
        for(char c : firstWord.toCharArray()) {
            alphaCntArr[c - 'A']++;
        }

        for(int i=1; i<N; i++) {
            String word = br.readLine();
            if(Math.abs(word.length() - firstWord.length()) >= 2) continue;
            solution(word);
        }

        System.out.println(answer);

        br.close();
    }
}
