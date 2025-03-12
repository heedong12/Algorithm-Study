package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _7795  {
    static int T;
    static int answer;
    static int[] arrA;
    static int[] arrB;

    static int binarySearch(int key, int first, int last) {
        while (first <= last) {
            int mid = (first+last)/2;

            if(arrB[mid] < key) first = mid+1;
            else last = mid-1;
        }
        return first;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            answer = 0;
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            arrA = new int[N];
            arrB = new int[M];

            input = br.readLine().split(" ");
            for(int i=0; i<N;i++) arrA[i] = Integer.parseInt(input[i]);

            input = br.readLine().split(" ");
            for(int i=0; i<M;i++) arrB[i] = Integer.parseInt(input[i]);

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            for(int a : arrA) {
                answer += binarySearch(a, 0, M-1);
            }

            System.out.println(answer);
        }
    }
}
