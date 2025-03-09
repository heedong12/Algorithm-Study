import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int sq = Integer.parseInt(input[0]);
		
		int[] arr = new int[n+1];
		boolean[] visited = new boolean[n+1];
		long[] f = new long[n+1];
		
		f[0] = 1;
		for(int i = 1; i <= n; i++) {
			f[i] = f[i-1] *i;
		}
		if(sq == 1) {
			long k = Long.parseLong(input[1]);
			for(int i = 0; i < n; i++) {
				for(int j = 1; j <=n ; j++) {
					if(visited[j]) continue;
					
					if(k > f[n-i-1]) {
						k -= f[n-i-1];
					}else {
						arr[i] = j;
						visited[j] = true;
						break;
					}
			
				}
			}
			for(int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			
		}else if(sq == 2){
			long k = 1;
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i+1]);
			}
			for(int i = 0; i < n; i++) {
				for(int j = 1; j < arr[i]; j++) {
					if(visited[j] == false) {
						k += f[n-i-1];
					}
				}
				visited[arr[i]] = true;
			}
			System.out.println(k);
		}
	}

}
