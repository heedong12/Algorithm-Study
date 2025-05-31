import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] a = new int[m];
        int[] b = new int[m];

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        int time = 24 * n;
        int[] score = Arrays.copyOf(a, m);

        for (int i = 0; i < m; i++) {
            if (score[i] < 100) {
                int increase  = Math.min(b[i], 100 - score[i]);
                pq.offer(new int[]{increase , i});
            }
        }

        while (time > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];

            if (score[i] >= 100) continue;

            score[i] += cur[0];
            if (score[i] > 100) score[i] = 100;

            time--;

            if (score[i] < 100) {
                int newIncrease  = Math.min(b[i], 100 - score[i]);
                pq.offer(new int[]{newIncrease, i});
            }

        }

        int result = 0;
        for (int s : score) result += s;
        System.out.println(result);
    }
}
