import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] arr = new int[n];
		
		input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		
		int cnt = 0 , sum = 0, left = 0, right = 0;
		while(right < n) {
			sum += arr[right];
			
			while(sum > m) {
				sum -= arr[left++];
			}
			if(sum == m) {
				cnt++;
			}
			right++;
		}
		System.out.println(cnt);

	}

}
