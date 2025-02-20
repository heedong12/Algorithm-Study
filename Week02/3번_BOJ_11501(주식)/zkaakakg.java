import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc ++) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = n - 1; i > -1; i--) {
				if(arr[i] > max) {
					max = arr[i];
				}else {
					result += (max - arr[i]);
				}
			}
			System.out.println(result);
		}
	}
}
