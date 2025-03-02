import java.io.*;
import java.util.*;


public class Main {
    static HashMap<Long, Long> dp = new HashMap<>();
    static long P, Q;
    public static long sequence(Long i) {
        if(i==0) return 1;

        if (dp.containsKey(i)) return dp.get(i);

        long result = sequence(i / P) + sequence(i / Q);
        dp.put(i, result);
        return result;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(sequence(N));
    }
}
