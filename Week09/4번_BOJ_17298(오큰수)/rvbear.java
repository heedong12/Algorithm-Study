import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int[] s = new int[n + 1];
        s[0] = -1;
        int pointer = 0;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (pointer == 0) {
                res[i] = -1;
                s[++pointer] = a[i];
            } else {
                while (pointer > 0 && s[pointer] <= a[i]) {
                    pointer--;
                }
                res[i] = s[pointer];
                s[++pointer] = a[i];
            }
        }

        for (int num : res) {
            stb.append(num).append(" ");
        }

        System.out.println(stb);
    }
}
