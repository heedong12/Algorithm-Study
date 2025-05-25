import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static List<int[]> snake = new ArrayList<>();
    static int n, k, l;
    static HashMap<Integer, String> hash = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean isFinish(int nx, int ny) {
        if (nx < 1 || ny < 1 || nx > n || ny > n) {
            return true;
        }

        for (int[] t : snake) {
            if (nx == t[0] && ny == t[1]) {
                return true;
            }
        }

        return false;
    }

    static void solve() {
        int cx = 1, cy = 1;
        int time = 0;
        int d = 0;
        snake.add(new int[]{1, 1});

        while (true) {
            time++;

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (isFinish(nx, ny))
                break;

            if (map[nx][ny]) {
                map[nx][ny] = false;
                snake.add(new int[]{nx, ny});

            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            if (hash.containsKey(time)) {
                d = hash.get(time).equals("D") ? (d + 1) % 4 : (d + 3) % 4;
            }

            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = true;
        }

        l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            String c = input[1];
            hash.put(x, c);
        }

        solve();
    }
}
