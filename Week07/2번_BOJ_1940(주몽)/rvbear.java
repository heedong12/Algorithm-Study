import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        boolean[] visit = new boolean[100001];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(stk.nextToken());
            visit[numList[i]] = true;
        }

        int cnt = 0;
        for (int num : numList) {
            int target = m - num;

            if (-1 < target && target < 100001 && visit[target]) {
                cnt++;
            }
        }

        System.out.println(cnt / 2);
    }
}
