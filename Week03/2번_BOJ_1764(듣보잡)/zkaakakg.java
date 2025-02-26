import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		HashSet<String> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < n; i ++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i< m; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				result.add(str);
			}	
		}
		
		Collections.sort(result);
		int cnt = result.size();
		System.out.println(cnt);
		for(int i = 0; i < cnt; i++) {
			System.out.println(result.get(i));
		}

	}

}
