import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
        
		while(true) {
			String[] input = br.readLine().split(" ");
			long n = Long.parseLong(input[0]);
			long m = Long.parseLong(input[1]);
			
			if(n == 0 && m == 0) break;
			
			HashSet<Long> set = new HashSet<>();
			for(int i = 0; i < n ; i ++) {
				set.add(Long.parseLong(br.readLine()));
			}
            
			int cnt = 0;
			for(int i = 0; i < m; i++) {
				long temp = Long.parseLong(br.readLine());
				if(set.contains(temp)) {
					cnt++;
				}
			}
      sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());

	}

}
