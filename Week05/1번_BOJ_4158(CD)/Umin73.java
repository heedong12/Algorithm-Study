package 백준;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _4158 {
    static Long N, M;
    static Set<Long> set1;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            answer = 0;
            String[] input = br.readLine().split(" ");
            N = Long.parseLong(input[0]);
            M = Long.parseLong(input[1]);

            if(N == 0 && M == 0) break;

            set1 = new HashSet<Long>();
            for (int i = 0; i < N; i++) set1.add(Long.parseLong(br.readLine()));
            for (int i = 0; i < M; i++) {
                Long temp = Long.parseLong(br.readLine());
                if (set1.contains(temp)) answer++;
            }

            System.out.println(answer);
        }

        br.close();
    }
}
