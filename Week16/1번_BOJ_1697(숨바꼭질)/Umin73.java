package 백준;

import java.io.*;
import java.util.*;

public class _1697 {

    static int N, K;
    static Queue<int[]> queue;
    static boolean[] visited;

    static int solution(int x) {
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            if(pos == K) return time;

            int[] nextPosArr = {pos+1, pos-1, pos*2};
            for(int next: nextPosArr) {
                if(next >=0 && next <= 100000) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(new int[]{next, time+1});
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 수빈이 위치
        K = Integer.parseInt(input[1]); // 동생 위치

        queue = new LinkedList<>();
        visited = new boolean[100001];

        System.out.println(solution(N));

        br.close();
    }
}
