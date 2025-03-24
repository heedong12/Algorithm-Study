package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1940 {
//    static int N, M;
//    static int[] arr;
//    static int answer = 0;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
//
//        arr = new int[N];
//        String[] input = br.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(input[i]);
//        }
//
//        Arrays.sort(arr);
//
//        int p1 = 0, p2 = N-1;
//        int tempSum = 0;
//        while( p1 < p2) {
//            tempSum = arr[p1] + arr[p2];
//
//            if(tempSum == M) {
//                answer++;
//                p1++;
//            } else if(tempSum < M) {
//                p1++; // tempSum이 M보다 작으면 왼쪽에 있는 포인터 증가시킴
//            } else {
//                p2--; // tempSum > M이면 p2를 줄여서 tempSum의 값도 줄임
//            }
//        }
//        System.out.println(answer);
//        br.close();
//    }

    static int N, M;
    static Set<Integer> set = new HashSet<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int tempNum = Integer.parseInt(input[i]);

            int otherNum = M - tempNum;
            if(set.contains(otherNum)) answer++;
            set.add(tempNum);
        }
        System.out.println(answer);
        br.close();
    }
}
