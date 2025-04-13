package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _17298 {
    static int N;
    static int[] arr;
    static int[] NGE;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        NGE = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        deque = new ArrayDeque<>(); // 오큰수 아직 못찾은 인덱스들
        for(int i=0; i<N; i++) {
            while(!deque.isEmpty() && arr[deque.peek()] < arr[i]) {
                NGE[deque.pop()] = arr[i];
            }
            deque.push(i);
        }

        while(!deque.isEmpty()) {
            NGE[deque.pop()] = -1;
        }

        for(int i=0; i<N; i++) {
            sb.append(NGE[i] + " ");
        }
        System.out.println(sb);
        br.close();
    }
}
