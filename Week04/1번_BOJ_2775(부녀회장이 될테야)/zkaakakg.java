import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[k+1][n+1];
			
			for(int i = 0; i < n+1 ; i++) {
				arr[0][i] = i;
			}
			for(int i = 0; i < k+1 ; i++) {
				arr[i][1] = 1;
			}
			
			for(int i = 1; i< k+1; i++) {
				for(int j = 2; j < n+1; j++) {
					arr[i][j] = arr[i][j-1] + arr[i-1][j]; 
				}
			}
			
			System.out.println(arr[k][n]);
			
		}
		
	}

}
