package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1253_2 {

    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
            int good = arr[i];
            int p1 = 0;
            int p2 = N-1;

            while (p1 < p2) {
                // good 자기 자신 피하기
                if(p1 == i) {
                    p1++;
                    continue;
                }
                if(p2 == i) {
                    p2--;
                    continue;
                }

                int tempSum = arr[p1] + arr[p2];
                if(tempSum > good) p2--;
                else if(tempSum < good) p1++;
                else if(tempSum == good) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

        br.close();
    }
}
