import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] meeting = new long[(int)N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            meeting[i][0] = Long.parseLong(input[0]);
            meeting[i][1] = Long.parseLong(input[1]);
        }

        Arrays.sort(meeting, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return o1[1] == o2[1] ? (int)(o1[0] - o2[0]) : (int)(o1[1] - o2[1]);
            }
        });

        int cnt = 1;
        long endTime = meeting[0][1];

        for (int i = 1; i < N; i++) {
            if (endTime <= meeting[i][0]) {
                cnt++;
                endTime = meeting[i][1];
            }
        }

        System.out.println(cnt);
    }
}
