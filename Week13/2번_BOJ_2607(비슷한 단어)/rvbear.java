import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            String target = br.readLine();
            int cnt = 0;
            int[] word = new int[26];

            for (int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for (int j = 0; j < target.length(); j++) {
                int idx = target.charAt(j) - 'A';
                if (word[idx] > 0) {
                    cnt++;
                    word[idx]--;
                }
            }

            if (first.length() == target.length() && (first.length() == cnt || first.length() - 1 == cnt)) {
                res++;
            } else if (first.length() == target.length() - 1 && target.length() - 1 == cnt) {
                res++;
            } else if (first.length() == target.length() + 1 && target.length() == cnt) {
                res++;
            }
        }

        System.out.println(res);
    }
}
