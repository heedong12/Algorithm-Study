package 백준;

import java.io.*;

public class _13251 {
    static int M, N, K;
    static double answer = 0;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        color = new int[M];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            color[i] += Integer.parseInt(input[i]);
            N += color[i];
        }

        K = Integer.parseInt(br.readLine());

        if(M == 1 || K == 1) {
            answer = 1.0;
        } else {
            for(int i=0; i<M; i++) {
                double temp = 1;
                for(int j=0; j<K; j++) {
                    temp *= ((double) (color[i] - j) / (N-j));
                }
                answer += temp;
            }
        }


        System.out.println(answer);

        br.close();
    }
}
