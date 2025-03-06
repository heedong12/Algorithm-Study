import java.io.*;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		
		arr = new int[n+1][k+1];
		System.out.print(solution(n,k));
	}
	
	public static int solution(int n, int r) {
        if(arr[n][r] > 0) return arr[n][r];
		if(n == r || r == 0) return arr[n][r] = 1; 
		
		return arr[n][r] = (solution(n-1, r-1) + solution(n-1, r)) % 10007;
	}

}
