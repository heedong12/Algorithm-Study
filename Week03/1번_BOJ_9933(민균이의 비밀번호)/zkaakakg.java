import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		String result = "";
		
		for(int i = 0; i < n; i ++) {
			String str = br.readLine();
			set.add(str);
			
			String reverse = new StringBuilder(str).reverse().toString();

			if(set.contains(reverse)) {
				result = str;
			}
		}
		
		int len = result.length();
		System.out.print(len + " " + result.charAt(len/2));
		
		
	
	}

}
