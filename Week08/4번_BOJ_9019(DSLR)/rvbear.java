import java.io.*;
import java.util.*;

public class Main {
    static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int d() {
            return (num * 2) % 10000;
        }

        int s() {
            return num == 0 ? 9999 : num - 1;
        }

        int l() {
            return num % 1000 * 10 + num / 1000;
        }

        int r() {
            return num % 10 * 1000 + num / 10;
        }
    }
    
    public static String bfs(int start, int target) {
        boolean[] visit = new boolean[10000];

        Queue<Register> q = new LinkedList<>();
        q.offer(new Register(start, ""));
        visit[start] = true;

        while (!q.isEmpty()) {
            Register now = q.poll();
            if (target == now.num) {
                return now.command;
            }

            if (!visit[now.d()]) {
                q.add(new Register(now.d(), now.command + "D"));
                visit[now.d()] = true;
            }

            if (!visit[now.s()]) {
                q.add(new Register(now.s(), now.command + "S"));
                visit[now.s()] = true;
            }

            if (!visit[now.l()]) {
                q.add(new Register(now.l(), now.command + "L"));
                visit[now.l()] = true;
            }

            if (!visit[now.r()]) {
                q.add(new Register(now.r(), now.command + "R"));
                visit[now.r()] = true;
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            stb.append(bfs(Integer.parseInt(input[0]), Integer.parseInt(input[1]))).append("\n");
        }

        System.out.print(stb.toString());
    }
}
