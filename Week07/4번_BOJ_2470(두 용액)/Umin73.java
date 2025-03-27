package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2470 {
    static int N;
    static int[] arr;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int p1 = 0, p2 = N-1;
        int value = Integer.MAX_VALUE;
        while(p1 < p2) {
            int tempValue = arr[p1]+arr[p2];

            if(Math.abs(tempValue) < value) {
                value = Math.abs(tempValue);
                answer[0] = arr[p1];
                answer[1] = arr[p2];
            }

            if(tempValue < 0) p1++;
            else p2--;
        }

        System.out.println(answer[0] + " " + answer[1]);
        br.close();
    }
}
