import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int idx = 1;

        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            stb.append("Case ").append(idx).append(": ");

            if ((V % P) < L) {
                stb.append((V / P) * L + (V % P)).append("\n");
            } else {
                stb.append((V / P) * L + L).append("\n");
            }
            idx++;
        }

        System.out.print(stb.toString());
    }
}
