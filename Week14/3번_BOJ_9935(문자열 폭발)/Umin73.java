package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9935 {

    static String word;
    static String bombWord;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        bombWord = br.readLine();
        answer = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            answer.append(word.charAt(i));
            if(answer.length() >= bombWord.length()) {
                if(answer.substring(answer.length() - bombWord.length()).equals(bombWord))
                    answer.delete(answer.length() - bombWord.length(), answer.length());
            }
        }

        if(answer.length() == 0) System.out.println("FRULA");
        else System.out.println(answer);

        br.close();
    }
}
