import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        char[] n = br.readLine().toCharArray();
        int[] num = new int[10];
        int total = 0;
        boolean flag = false;

        for (char d : n) {
            int temp = d - '0';
            num[temp]++;
            total += temp;

            if (temp == 0) {
                flag = true;
            }
        }

        if (!flag || total % 3 != 0) {
            stb.append(-1);
        } else {
            for (int i = 9; i >= 0; i--) {
                while (num[i] > 0) {
                    stb.append(i);
                    num[i]--;
                }
            }
        }

        System.out.println(stb);
    }
}
