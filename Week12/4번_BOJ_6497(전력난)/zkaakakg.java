import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");

            int m = Integer.parseInt(input[0]);  
            int n = Integer.parseInt(input[1]);  

            if (m == 0 && n == 0) break;  

            List<Edge>[] graph = new List[m];
            for (int i = 0; i < m; i++) {
                graph[i] = new ArrayList<>();
            }

            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);

                graph[x].add(new Edge(y, z));
                graph[y].add(new Edge(x, z));
                totalCost += z;
            }

            boolean[] visited = new boolean[m];
            int[] minEdge = new int[m];
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            minEdge[0] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0));

            int cost = 0;

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int u = current.vertex;
                int weight = current.weight;

                if (visited[u]) continue;

                visited[u] = true;
                cost += weight;

                for (Edge next : graph[u]) {
                    if (!visited[next.vertex] && next.weight < minEdge[next.vertex]) {
                        minEdge[next.vertex] = next.weight;
                        pq.offer(next);
                    }
                }
            }

            System.out.println(totalCost - cost);
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex, weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
