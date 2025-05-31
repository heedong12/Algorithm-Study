import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {


    public static class subjects implements Comparable<subjects> {
        int id;
        int number;

        subjects(int id, int number) {
            this.id = id;
            this.number = number;
        }

        public int compareTo(subjects g) {
            return g.number - this.number;
        }

    }

    static int N;
    static int M;
    static int[] arr;
    static PriorityQueue<subjects> growths;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) * 24;
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        growths = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            growths.add(new subjects(i, number));
        }

        while(N > 0 && !growths.isEmpty()) {
            subjects p = growths.poll();
            int time = ((100 - arr[p.id]) / p.number);
            int realTime = Math.min(N, time);

            N -= realTime;
            arr[p.id] += p.number * realTime;

            if(arr[p.id] != 100) {
                growths.add(new subjects(p.id, 100 - arr[p.id]));
            }

        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}