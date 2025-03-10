import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int n, m, res, idxN, idxM;
        long[] arrN, arrM;

        while (true) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            if (n == 0 && m == 0) {
                break;
            }

            arrN = new long[n];
            arrM = new long[m];

            for (int i = 0; i < n; i++) {
                arrN[i] = Long.parseLong(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                arrM[i] = Long.parseLong(br.readLine());
            }

            res = 0;
            idxN = 0;
            idxM = 0;
            while (idxN < n && idxM < m) {
                if (arrN[idxN] == arrM[idxM]) {
                    res++;
                    idxN++;
                    idxM++;
                } else if (arrN[idxN] < arrM[idxM]) {
                    idxN++;
                } else {
                    idxM++;
                }
            }

            stb.append(res).append("\n");
        }

        System.out.println(stb.toString());
    }
}
