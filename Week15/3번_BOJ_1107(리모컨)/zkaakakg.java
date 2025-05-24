import java.io.*;

public class Main {
    static int n, m;
    static boolean[] arr;

    public static int solution(int i){
        if (i == 0){
            return arr[0] ? 0 : 1;
        }

        int len = 0;
        while (i > 0){
            if (arr[i % 10]) return 0;
            i /= 10;
            len++;
        }
        return len;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new boolean[10];
        if ( m != 0){
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                arr[Integer.parseInt(input[i])] = true;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            int len = solution(i);
            if (len > 0){
                int min = len + Math.abs(n - i);
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
