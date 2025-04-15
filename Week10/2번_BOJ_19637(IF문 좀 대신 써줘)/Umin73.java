package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class _19637 {
    static int N, M;
    static int[] powerNumArr;
    static String[] powerStrArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 칭호의 개수
        M = Integer.parseInt(input[1]); // 캐릭터들의 개수

        powerNumArr = new int[N];
        powerStrArr = new String[N];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            powerStrArr[i] = input[0];
            powerNumArr[i] = Integer.parseInt(input[1]);
        }

        for(int i=0; i<M; i++) {
            int power = Integer.parseInt(br.readLine());
            int answerIdx = 0;
            int left = 0;
            int right = N-1;
            while (left <= right) {
                int mid = (left+right)/2;
                if(power <= powerNumArr[mid]) {
                    right = mid-1;
                    answerIdx = mid;
                } else {
                    left=mid+1;
                }
            }
            sb.append(powerStrArr[answerIdx]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
