import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        int[] plates = new int[n];
        int[] count = new int[d + 1];

        for (int i = 0; i < n; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }

        int kind = 0;
        for (int i = 0; i < k; i++) {
            if (count[plates[i]] == 0) {
                kind++;
            }
            count[plates[i]]++;
        }

        int max = 0;
        if (count[c] == 0) {
            max = kind + 1;
        } else {
            max = kind;
        }

        for (int i = 1; i < n; i++) {
            int remove = plates[(i - 1) % n];
            int add = plates[(i + k - 1) % n];

            count[remove]--;
            if (count[remove] == 0) kind--;

            if (count[add] == 0) kind++;
            count[add]++;

            int total;
            if (count[c] == 0) {
                total = kind + 1;
            } else {
                total = kind;
            }
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}
