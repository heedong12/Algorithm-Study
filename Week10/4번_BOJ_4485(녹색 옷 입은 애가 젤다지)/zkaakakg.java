import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            arr = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            System.out.println("Problem " + idx +": " + dist[n-1][n-1]);
            idx++;
        }
    }

    public static void dijkstra() {
        PriorityQueue pq = new PriorityQueue<>();
        dist[0][0] = arr[0][0];
        pq.offer(new Node(0, 0, arr[0][0]));

        while (!pq.isEmpty()) {
            Node current = (Node) pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            if (cost > dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int nc = cost + arr[nx][ny];
                    if (nc < dist[nx][ny]) {
                        dist[nx][ny] = nc;
                        pq.offer(new Node(nx, ny, nc));
                    }
                }
            }
        }

    }

}
