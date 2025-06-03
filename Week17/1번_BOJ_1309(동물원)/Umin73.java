package 백준;

import java.io.*;

public class _1309 {

    static int N;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println(0);
            return;
        }
        if(N == 1) {
            System.out.println(3);
            return;
        }

        arr = new int[N][3];

        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;

        for(int i = 1; i < N; i++) {
            arr[i][0] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2])%9901;
            arr[i][1] = (arr[i-1][0] + arr[i-1][2])%9901;
            arr[i][2] = (arr[i-1][0] + arr[i-1][1])%9901;
        }
        System.out.println((arr[N-1][0]+arr[N-1][1]+arr[N-1][2])%9901);

        br.close();
    }
}
