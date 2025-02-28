import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int  n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> map = new HashMap<>();
			
			
			for(int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				if(map.containsKey(input[1])) {
					map.put(input[1], map.get(input[1])+1);
					}else {
						map.put(input[1], 1);
					}
				}
			int result = 1;
			for(int value : map.values()) {
				result *= (value+1);
			}
			System.out.println(result-1);
		}
	}
}


