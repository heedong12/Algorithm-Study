import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int truthCnt = Integer.parseInt(input[0]);
        boolean[] truthPeople = new boolean[n + 1];
        for (int i = 0; i < truthCnt; i++) {
            truthPeople[Integer.parseInt(input[i + 1])] = true;
        }

        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int partyCnt = Integer.parseInt(input[0]);
            int[] party = new int[partyCnt];
            for (int j = 0; j < partyCnt; j++) {
                party[j] = Integer.parseInt(input[j+1]);
            }

            for (int j = 1; j < partyCnt; j++) {
                union(party[0], party[j]);
            }

            parties.add(party);
        }

        boolean[] truthRoot = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (truthPeople[i]){
                truthRoot[find(i)] = true;
            }
        }

        int cnt = 0;
        for (int[] party : parties){
            boolean isLie = true;
            for (int person : party){
                if (truthRoot[find(person)]){
                    isLie = false;
                    break;
                }
            }
            if (isLie) cnt++;
        }

        System.out.println(cnt);
    }
}
