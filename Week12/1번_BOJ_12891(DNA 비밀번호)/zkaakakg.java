import java.io.*;
import java.util.*;

public class Main {
    static int s, p;
    static char[] dna;
    static int[] cnt;
    static int[] required;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        s = Integer.parseInt(input[0]);
        p = Integer.parseInt(input[1]);

        dna = br.readLine().toCharArray();
        cnt = new int[4];

        required = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < p; i++) {
            updateCnt(i, +1);
        }

        int result = 0;
        if (isCheck()) result++;

        for (int i = p; i < s; i++) {
            updateCnt(i - p, -1);
            updateCnt(i, +1);

            if (isCheck()) result++;
        }

        System.out.println(result);
    }

    public static void updateCnt(int i, int n) {
        switch (dna[i]) {
            case 'A':
                cnt[0] += n;
                break;
            case 'C':
                cnt[1] += n;
                break;
            case 'G':
                cnt[2] += n;
                break;
            case 'T':
                cnt[3] += n;
                break;
        }
    }

    public static boolean isCheck(){
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < required[i]) return false;
        }
        return true;
    }
}
