import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 집 개수
            int N = Integer.parseInt(st.nextToken()); // 도로 개수

            if (M == 0 && N == 0) break;

            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                graph.add(new ArrayList<>());
            }

            int totalCost = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new int[]{to, cost});
                graph.get(to).add(new int[]{from, cost});
                totalCost += cost;
            }

            boolean[] visited = new boolean[M];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{0, 0});
            int minCost = 0;

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0];
                int cost = curr[1];

                if (visited[node]) continue;
                visited[node] = true;
                minCost += cost;

                for (int[] neighbor : graph.get(node)) {
                    if (!visited[neighbor[0]]) {
                        pq.offer(new int[]{neighbor[0], neighbor[1]});
                    }
                }
            }

            System.out.println(totalCost - minCost);
        }
    }
}
