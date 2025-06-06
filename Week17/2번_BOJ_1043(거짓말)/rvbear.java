import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Integer> list;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    static void union(int x, int y) {
        if (list.contains(y)) {
            int temp = x;
            x = y;
            y = temp;
        }

        parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        if (num == 0) {
            System.out.println(m);
            return;
        }

        list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int personNum = Integer.parseInt(input[0]);

            int x = Integer.parseInt(input[1]);
            party[i].add(x);

            for (int j = 2; j <= personNum; j++) {
                int y = Integer.parseInt(input[j]);
                union(find(x), find(y));
                party[i].add(y);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;

            for (int person : party[i]) {
                if (list.contains(find(parent[person]))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
