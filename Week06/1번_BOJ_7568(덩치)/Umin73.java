package 백준;

import java.io.*;

public class _7568 {
    static int N;
    static int[][] arr;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        rank = new int[N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arr[i][0] = x;
            arr[i][1] = y;
            rank[i] = 1; //기본등수 1에 자신보다 덩치 큰 사람 수 더하기
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank[i]++;
            }
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
