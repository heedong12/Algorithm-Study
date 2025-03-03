package 백준;

import java.io.*;

public class _2775 {
    static int T, K, N;

    static int solution() {
        int[] arr = new int[N];

        // 1: 1 2 3
        // 2: 1 1+2 1+2+3
        // 3: 1 1+1+2 1+1+2+1+2+3

        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for(int i = 0; i < K; i++) {
            for(int j = 1; j < N; j++) {
                arr[j] += arr[j-1];
            }
        }

        return arr[N-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            System.out.println(solution());
        }

        br.close();
    }
}
