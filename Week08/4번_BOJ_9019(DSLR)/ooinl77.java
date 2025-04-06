import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            //null 방지
            Arrays.fill(command, "");

            bfs(A, B, visited, command);
            System.out.println(command[B]);
        }
    }

    static void bfs(int start, int target, boolean[] visited, String[] command) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;


        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextNums = { D(current), S(current), L(current), R(current) };
            char[] commands = { 'D', 'S', 'L', 'R' };

            for (int i = 0; i < 4; i++) {
                int next = nextNums[i];
                if (!visited[next]) {
                    visited[next] = true;
                    command[next] = command[current] + commands[i];
                    queue.add(next);
                }
            }
            // 목표 숫자면 끝
            if (visited[target]) return;
        }
    }

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    static int R(int n) {
        return (n % 10) * 1000 + (n / 10);
    }
}