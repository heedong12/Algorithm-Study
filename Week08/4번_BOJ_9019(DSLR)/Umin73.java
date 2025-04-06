package 백준;

import java.io.*;
import java.util.ArrayDeque;

public class _9019 {
    static int T, A, B;
    static int MAX = 9999;
    static ArrayDeque<Integer> queue;
    static boolean[] visited;
    //    static String[] candidate;
    static int[] parent;
    static char[] chars;

    static void printCommands() {
        StringBuilder sb = new StringBuilder();
        int c = B;
        while(c != A) {
            sb.append(chars[c]);
            c = parent[c];
        }
        System.out.println(sb.reverse());
    }

    static void BFS() {
        visited = new boolean[MAX+1];
//        candidate = new String[MAX+1];
        parent = new int[MAX+1];
        chars = new char[MAX+1];
        queue = new ArrayDeque<>();

        visited[A] = true;
//        candidate[A] = "";
        queue.offer(A);

        while(!queue.isEmpty()) {
            int curNum = queue.poll();

            int D = (2*curNum) % (MAX+1);
            int S = curNum == 0 ? MAX : curNum - 1;
            int L = (curNum%1000) * 10 + (curNum/1000);
            int R = (curNum%10)*1000 + (curNum / 10);

            int[] commands = {D, S, L, R};
            char[] commandChars = {'D', 'S', 'L','R'};
            for (int i=0; i<4; i++) {
                int nextNum = commands[i];
                if(!visited[nextNum]) {
                    visited[nextNum] = true;
//                    candidate[nextNum] = candidate[curNum]+commandChars[i];
                    parent[nextNum] = curNum;
                    chars[nextNum] = commandChars[i];
                    if(nextNum == B) {
                        printCommands();
                        return;
                    }
                    queue.offer(nextNum);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            BFS();
        }
    }
}
