import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new ArrayList[n];
        visited = new boolean[n];
        cnt = 0;

        int[] header = new int[n];
        List<Integer> headerList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int from = input[0].charAt(0) - 'A';
            int to = input[1].charAt(0) - 'A';
            graph[from].add(to);
            header[to]++;
        }

        for (int i = 0; i < header.length; i++) {
            if (header[i] == 0){
                headerList.add(i);
            }
        }

        input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        for (int i = 1; i <= num; i++) {
            int idx = input[i].charAt(0) - 'A';

            graph[idx].clear();
            if (!headerList.contains(idx)){
                for (int j = 0; j < graph.length; j++) {
                    graph[j].remove(Integer.valueOf(idx));
                }
            }
        }

        for (int i = 0; i < header.length; i++) {
            if (header[i] == 0) dfs(i);
        }

        System.out.println(cnt);


    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i : graph[start]) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
    }
}
