import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 수
        int c = Integer.parseInt(st.nextToken()); // 무료 초밥
        int[] plate = new int[N]; // 회전초밥
        int[] count = new int[d + 1]; // 초밥 별 갯수
        int kind = 0; // 연속 수 중 가짓수
        int max = 0;

        for (int i=0; i<N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                if (count[plate[i]] == 0) kind++;
                count[plate[i]]++;
            }
        }

        max = (count[c] == 0) ? kind + 1 : kind;

        for (int i = 1; i < N; i++) {
            int left = plate[i - 1];
            int right = plate[(i + k - 1) % N];

            count[left]--;
            if (count[left] == 0) kind--;

            if (count[right] == 0) kind++;
            count[right]++;

            int current = (count[c] == 0) ? kind + 1 : kind;
            max = Math.max(max, current);
        }

        System.out.println(max);
    }

}
