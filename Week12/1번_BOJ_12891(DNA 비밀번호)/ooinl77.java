import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = br.readLine().toCharArray();
        int[] ACGT = new int[4];
        int[] arr = new int[4];
        int result = 0;
        int checkACGT = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
            if (ACGT[i] == 0) checkACGT++;
        }

        for (int i = 0; i < P; i++) {
            int index = 0;

            if (A[i] == 'A') index = 0;
            else if (A[i] == 'C') index = 1;
            else if (A[i] == 'G') index = 2;
            else if (A[i] == 'T') index = 3;

            arr[index]++;
            if (arr[index] == ACGT[index]) checkACGT++;
        }

        if (checkACGT == 4) result++;

        for (int i = P; i < S; i++) {
            int index = 0;

            if (A[i] == 'A') index = 0;
            else if (A[i] == 'C') index = 1;
            else if (A[i] == 'G') index = 2;
            else if (A[i] == 'T') index = 3;

            arr[index]++;
            if (arr[index] == ACGT[index]) checkACGT++;

            if (A[i - P] == 'A') index = 0;
            else if (A[i - P] == 'C') index = 1;
            else if (A[i - P] == 'G') index = 2;
            else if (A[i - P] == 'T') index = 3;

            if (arr[index] == ACGT[index]) checkACGT--;
            arr[index]--;

            if (checkACGT == 4) result++;
        }

        System.out.println(result);
    }
}
