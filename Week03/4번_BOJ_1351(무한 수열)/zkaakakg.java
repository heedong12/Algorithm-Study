import java.io.*;
import java.util.*;
public class Main {
	static long n;
	static long p;
	static long q;
	static HashMap<Long,Long> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		n = Long.parseLong(input[0]);
		p = Long.parseLong(input[1]);
		q = Long.parseLong(input[2]);
		map.put(0L, 1L);
		System.out.println(solution(n));
		
	}
	
	static long solution(long n) {
		if (!map.containsKey(n)) {
            map.put(n, n == 0 ? 1 : solution(n / p) + solution(n / q));
        }
        return map.get(n);
		
	}

}
