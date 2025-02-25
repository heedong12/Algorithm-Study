import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] notListen = new String[n];
        for (int i = 0; i < n; i++) {
            notListen[i] = br.readLine();
        }

        String[] notSee = new String[m];
        for (int i = 0; i < m; i++) {
            notSee[i] = br.readLine();
        }

        Arrays.sort(notListen);
        Arrays.sort(notSee);

        int nIdx = 0, mIdx = 0, res = 0;
        while (nIdx < n && mIdx < m) {
            int comp = notListen[nIdx].compareTo(notSee[mIdx]);

            if (comp == 0) {
                stb.append(notListen[nIdx]).append("\n");
                res++;
                nIdx++;
                mIdx++;
            } else if (comp > 0) {
                mIdx++;
            } else {
                nIdx++;
            }
        }
        
        System.out.println(res);
        System.out.println(stb.toString());
    }
}
