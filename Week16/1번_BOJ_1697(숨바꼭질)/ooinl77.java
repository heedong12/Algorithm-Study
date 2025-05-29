import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 수빈
        int K = Integer.parseInt(st.nextToken());  // 동생

        int[] visited = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(visited[current] - 1);
                break;
            }

            int walkBackward = current - 1; // 뒤로 걷기
            int walkForward = current + 1; // 앞으로 걷기
            int warp = current * 2; // 순간이동

            int[] move = {walkBackward, walkForward, warp};

            for (int m : move) {
                if (m >= 0 && m < 100001 && visited[m] == 0) {
                    visited[m] = visited[current] + 1;
                    queue.add(m);
                }
            }
        }
    }
}
