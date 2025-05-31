import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]) * 24;
        int m = Integer.parseInt(input[1]);
        int[] value = new int[m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            value[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(input[i]);
            pq.offer(new int[]{i, num});
        }

        while (!pq.isEmpty() && n > 0) {
            int[] temp = pq.poll();
            int time = ((100 - value[temp[0]]) / temp[1]);

            time = Math.min(time, n);
            n -= time;
            value[temp[0]] += temp[1] * time;

            if (value[temp[0]] != 100) {
                pq.offer(new int[]{temp[0], 100 - value[temp[0]]});
            }
        }

        int sum = 0;
        for (int v : value) {
            sum += v;
        }

        System.out.println(sum);
    }
}
