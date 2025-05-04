import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static List<int[]> edgeList;

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            if (m == 0 && n == 0) {
                break;
            }

            edgeList = new ArrayList<>();

            int totalCost = 0;
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);

                edgeList.add(new int[]{x, y, z});
                totalCost += z;
            }

            edgeList.sort((o1, o2) -> o1[2] - o2[2]);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int minCost = 0;
            for (int i = 0; i < edgeList.size(); i++) {
                int[] edge = edgeList.get(i);

                if (find(edge[0]) != find(edge[1])) {
                    minCost += edge[2];
                    union(edge[0], edge[1]);
                }
            }

            stb.append(totalCost - minCost).append("\n");
        }

        System.out.print(stb);
    }
}
