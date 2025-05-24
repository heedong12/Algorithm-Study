import java.io.*;

public class Main {
    static int n, m, ans;
    static boolean[] check;

    static void dfs(int num, int depth) {
        if (depth == 6) {
            return;
        }
        
        num *= 10;
        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                ans = Math.min(ans, Math.abs(n - (num + i)) + depth + 1);
                dfs(num + i, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        check = new boolean[10];
        if (m != 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                check[Integer.parseInt(input[i])] = true;
            }
        }

        ans = Math.abs(n - 100);
        dfs(0, 0);
        System.out.println(ans);
    }
}
