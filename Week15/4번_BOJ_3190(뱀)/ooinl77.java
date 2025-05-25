import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine()); // 보드크기
        int K = Integer.parseInt(br.readLine()); // 사과 개수
        int[][] board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1; // 사과 위치
        }

        int L = Integer.parseInt(br.readLine()); // 뱀 이동 횟수
        Map<Integer, Character> snakeMove = new HashMap<>(); // 뱀 이동 정보
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            snakeMove.put(t, c);
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0}); // 시작 위치
        int time = 0;
        int x = 0, y = 0;
        int dir = 0;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽 또는 자기 몸에 부딪히면 종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            boolean hit = false;
            for (int[] s : snake) {
                if (s[0] == nx && s[1] == ny) {
                    hit = true;
                    break;
                }
            }
            if (hit) break;

            snake.offerFirst(new int[]{nx, ny});
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 있으면 꼬리 그대로
            } else {
                snake.pollLast(); // 사과 없으면 꼬리 자름
            }

            if (snakeMove.containsKey(time)) {
                char c = snakeMove.get(time);
                if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }
}
