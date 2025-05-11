package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _11060 {

    static int N;
    static int[] arr;
    static int[] minJumpArr;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[N];
        minJumpArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if(i>0) minJumpArr[i] = -1;
        }

        queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=1; i<=arr[cur]; i++) {
                int next = cur+i;
                if(next >= N) continue;
                if(minJumpArr[next] == -1) {
                    minJumpArr[next] = minJumpArr[cur] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(minJumpArr[N-1]);

        br.close();
    }
}
