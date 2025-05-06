package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13702 {

    static int N;
    static long K;
    static Long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 주문한 주전자 수
        K = Long.parseLong(input[1]); // K명의 친구들

        arr = new Long[N]; // 막걸리 배열
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long first = 1;
        long last = max;
        while(first <= last) {
            long mid = (first + last)/2;
            long cnt = 0; // 막걸리 줄 수 있는 사람 카운트
            for (int i=0;i<arr.length; i++) {
                cnt += (arr[i]/mid);
            }

            if(cnt < K) last = mid-1;
            else first = mid+1;
        }
        System.out.println(last);

        br.close();
    }
}
