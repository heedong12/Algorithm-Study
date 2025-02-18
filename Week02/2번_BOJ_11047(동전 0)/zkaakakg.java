import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] arr = new int[n];
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = n-1; i > -1; i--) {
			if(arr[i] <= k) {
				result += k / arr[i];
				k = k % arr[i];
			}else if(k == 0) {
				break;
			}
		}
		
		sb.append(result);
		System.out.println(sb.toString());

	}

}
