package 백준;

import java.io.*;
import java.util.*;

public class _1107 {

    static int N, M;
    static Set<Integer> brokenSet;
    static int answer;

    static void solution(int curNum, int depth) {
        if(depth > 6) return;

        if (depth > 0) {
            int clickCnt = depth + Math.abs(N - curNum);
            if (clickCnt < answer) answer = clickCnt;
        }

        for(int i=0; i<10; i++) {
            if(!brokenSet.contains(i)) solution((curNum*10)+i, depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        brokenSet = new HashSet<>();
        if(M > 0) {
            String[] input = br.readLine().split(" ");
            for(int i=0; i<M;i++) {
                brokenSet.add(Integer.parseInt(input[i]));
            }
        }

        answer = Math.abs(N - 100);

        solution(0,0);

        System.out.println(answer);

        br.close();
    }
}
