package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2003 {
    static int N, M;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(input[i]);
        }

        int p1 = 0, p2 = 0;
        int tempSum = 0;
        while (p1 < N) {
            while (p2 < N && tempSum < M) {
                tempSum += arr[p2++];
            }
            if (tempSum == M) answer++;
            tempSum -= arr[p1++];
        }
        System.out.println(answer);
        br.close();
    }
}
