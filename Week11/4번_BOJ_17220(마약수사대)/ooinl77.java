import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<List<Integer>> list;
    static boolean[] arrested;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'A';
            int to = st.nextToken().charAt(0) - 'A';
            list.get(from).add(to);
        }

        st = new StringTokenizer(br.readLine());
        int arrCount = Integer.parseInt(st.nextToken());
        arrested = new boolean[N];
        for (int i = 0; i < arrCount; i++) {
            int arrPerson = st.nextToken().charAt(0) - 'A';
            arrested[arrPerson] = true;
        }

        visited = new boolean[N];
        count = 0;

        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int neighbor : list.get(i)) {
                inDegree[neighbor]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0 && !arrested[i]) {
                dfs(i);
            }
        }

        System.out.println(count);
    }


    static void dfs(int i) {
        visited[i] = true;
        for (int v : list.get(i)) {
            if (!visited[v] && !arrested[v]) {
                count++;
                visited[v] = true;
                dfs(v);
            }
        }
    }
}