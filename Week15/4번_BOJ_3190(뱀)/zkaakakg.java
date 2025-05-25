import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int k = Integer.parseInt(br.readLine());
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            char c = input[1].charAt(0);
            map.put(x, c);
        }

        Deque<int[]> snake = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        snake.add(new int[]{1, 1});
        visited[1][1] = true;

        int time = 0;
        int x = 1, y = 1;
        int dir = 0;
        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || nx > n || ny < 1 || ny > n || visited[nx][ny]) {
                break;
            }

            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                snake.addLast(new int[]{nx, ny});
                visited[nx][ny] = true;
            } else {
                snake.addLast(new int[]{nx, ny});
                visited[nx][ny] = true;

                int[] tail = snake.pollFirst();
                visited[tail[0]][tail[1]] = false;
            }

            x = nx;
            y = ny;

            if (map.containsKey(time)) {
                char c = map.get(time);
                if (c == 'D') {
                    dir = (dir + 1) % 4;
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                }
            }
        }

        System.out.println(time);
    }
}
