package 백준;

import java.io.*;

public class _1722 {
    static int N;
    static long[] fact; //
    static boolean[] used;

    static void solution2(int[] arr) {
        long idx = 1;

        // 1 3 2 4
        /*
         * 첫번째 자리가 1 -> 순서가 1~6으로 좁혀짐
         * 두번째 자리가 3 -> 순서가 3~4로 좁혀짐
         * 세번째 자리가 2 -> 순거가 3으로 접혀짐
         * */

        for(int i=0; i<N; i++) {
            int num = arr[i]; // 현재 위치의 숫자

            for(int j=1; j<num; j++) {
                if(!used[j]) {
                    idx += fact[N-1-i];
                    /*
                     * 3이 맨 앞에 올 경우
                     * 1,2가 맨 앞에 오는 경우가 순서가 더 우선임
                     * 1이 먼저 오는 경우의 수 6
                     * 2가 먼저 오는 경우의 수 6
                     * 즉, 3이 맨 앞에 오는 경우는 12이후의 순서라는 것임
                     * */
                }
            }
            used[num] = true;
        }
        System.out.println(idx);
    }

    static void solution1(long K) {
        StringBuilder sb = new StringBuilder();

        if(K>0)K--;

        for(int i=0; i<N; i++) {
            for(int j=1; j<=N; j++) {
                if(used[j]) continue;

                if(K < fact[N-1-i]) {
                    sb.append(j).append(" ");
                    used[j] = true;
                    break;
                }

                K -= fact[N-1-i];
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        used = new boolean[N+1];

        fact = new long[N+1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i-1] * i;
        }

        String[] input = br.readLine().split(" ");
        int type = Integer.parseInt(input[0]);

        if(type == 1) {
            long K = Long.parseLong(input[1]);
            solution1(K);
        } else {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i+1]);
            }
            solution2(arr);
        }

        br.close();
    }
}
