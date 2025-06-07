import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int conanCount = Integer.parseInt(st.nextToken());
        boolean[] conan = new boolean[N + 1];
        List<Integer> conanList = new ArrayList<>();

        for (int i = 0; i < conanCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            conan[person] = true;
            conanList.add(person);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
            }

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }

            parties.add(party);
        }

        Set<Integer> truthParents = new HashSet<>();
        for (int person : conanList) {
            truthParents.add(find(person));
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthParents.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
import java.io.*;
        import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int conanCount = Integer.parseInt(st.nextToken());
        boolean[] conan = new boolean[N + 1];
        List<Integer> conanList = new ArrayList<>();

        for (int i = 0; i < conanCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            conan[person] = true;
            conanList.add(person);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
            }

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }

            parties.add(party);
        }

        Set<Integer> truthParents = new HashSet<>();
        for (int person : conanList) {
            truthParents.add(find(person));
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthParents.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
