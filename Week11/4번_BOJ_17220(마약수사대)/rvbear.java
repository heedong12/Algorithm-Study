import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static boolean[] visit;
    static List<List<Integer>> graph;

    static void dfs(int start) {
        if (!visit[start]) {
            List<Integer> target = graph.get(start);
            for (int t : target) {
                if (!visit[t]) {
                    cnt++;
                    dfs(t);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        graph = new ArrayList<>();
        visit = new boolean[n];
        int[] root = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            graph.get(input[0].charAt(0) - 'A').add(input[1].charAt(0) - 'A');
            root[input[1].charAt(0) - 'A']++;
        }

        input = br.readLine().split(" ");
        int arrest = Integer.parseInt(input[0]);

        for (int i = 0; i < arrest; i++) {
            int target = input[i + 1].charAt(0) - 'A';
            visit[target] = true;
        }

        for (int i = 0; i < n; i++) {
            if (root[i] == 0) {
                dfs(i);
            }
        }

        System.out.println(cnt);
    }
}
