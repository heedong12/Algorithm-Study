import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        int[] sushi = new int[n];
        int[] check = new int[d + 1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int ans = 1;
        check[c]++;
        for (int i = 0; i < k; i++) {
            if (check[sushi[i]] == 0) {
                ans++;
            }
            check[sushi[i]]++;
        }

        int cnt = ans;
        for (int i = 1; i < n; i++) {
            int temp = sushi[i - 1];
            check[temp]--;

            if (check[temp] == 0) {
                cnt--;
            }

            int add = sushi[(i + k - 1) % n];
            if (check[add] == 0) {
                cnt++;
            }
            check[add]++;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
