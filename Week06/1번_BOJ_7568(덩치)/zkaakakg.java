import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				if(i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					result[i]++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(result[i] + 1 + " ");
		}
		
		
	}

}
