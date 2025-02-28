import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, Long> map;
    static long p, q;

    static void putValue(long key) {
        map.put(key, key == 0L ? 1L : getValue(key / p) + getValue(key / q));
    }

    static long getValue(long key) {
        if (map.get(key) == null) {
            putValue(key);
        }
        
        return map.get(key);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(getValue(n));
    }
}
