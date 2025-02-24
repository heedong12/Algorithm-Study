import java.io.*;
import java.util.HashSet;

public class _9933 {
    static int N;
    static HashSet<String> set = new HashSet<>();
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N; i++) {
            String word = br.readLine();
            String reversedWord = new StringBuilder(word).reverse().toString();

            if(!set.contains(reversedWord)) {
                set.add(word);
            }

            if(set.contains(reversedWord) || word.equals(reversedWord)) {
                answer = word;
            }
        }

        int length = answer.length();
        char middleChar = answer.charAt(length/2);
        bw.write(length + " " + middleChar + "\n");

        bw.close();
        br.close();
    }
}
