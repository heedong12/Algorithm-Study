package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3273 {
    static int N, X;
    static int[] arr;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        X = Integer.parseInt(br.readLine());

        // solution 1 : 340ms
//        int p1 = 0, p2 =N-1;
//        int tempSum = 0;
//        while(p1 < p2) {
//            tempSum = arr[p1] + arr[p2];
//
//            if(tempSum == X) {
//                answer++;
//                p1++;
//            } else if(tempSum < X){
//                p1++;
//            } else {
//                p2--;
//            }
//        }

        // solution 2 : 256ms
        visited = new boolean[X+1];
        for(int i=0; i<N; i++) {
            int curNum = arr[i];
            int otherNum = X - curNum;

            if(otherNum <= X && otherNum >= 0){
                if(visited[otherNum]) answer++;
            }
            if(curNum <= X && curNum >= 0) {
                visited[curNum] = true;
            }
        }

        System.out.println(answer);

        br.close();
    }

}
