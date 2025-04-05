import java.io.*;
import java.util.*;

public class Main {
    static int a, b;
    static List<String> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            result = new ArrayList<>();

            bfs();

            for (String s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void bfs() {
        boolean[] visited = new boolean[10000];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(a, ""));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int d = (current.num * 2) % 10000;
            int s = (current.num == 0) ? 9999 : current.num - 1;
            int l = (current.num % 1000) * 10 + (current.num / 1000);
            int r = (current.num % 10) * 1000 + (current.num / 10);

            if (current.num == b) {
                result.add(current.commands);
                break;
            }

            if (!visited[d]) {
                visited[d] = true;
                queue.add(new Node(d, current.commands + "D"));
            }
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new Node(s, current.commands + "S"));
            }
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new Node(l, current.commands + "L"));
            }
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new Node(r, current.commands + "R"));
            }
        }
    }

    static class Node {
        int num;
        String commands;

        Node(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }
}

