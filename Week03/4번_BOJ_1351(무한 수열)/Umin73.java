import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class _1351 {
    static Long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    static Long solution(long n) {
        if(map.containsKey(n)) return map.get(n);

        long result = solution(n/P) + solution(n/Q);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);

        map.put(0L,1L);
        System.out.println(solution(N));

        br.close();
    }
}
