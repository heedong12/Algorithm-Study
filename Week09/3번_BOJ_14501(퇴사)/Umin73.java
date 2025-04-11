package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14501 {
    static int N;
    static int[][] arr; // arr[i][0]: 상담 완료 기간(T), arr[i][1]: 상담 금액(P)
    static int answer = 0;

    static void solution(int T, int P) {
        if(T <= N) {
            answer = Math.max(answer, P);
        }

        if(T == N) {
            return;
        }

        for(int i=T; i<N; i++) {
            if(i+arr[i][0] <= N) {
                solution(i+arr[i][0], P+arr[i][1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        solution(0,0);

        System.out.println(answer);
        br.close();
    }
}
