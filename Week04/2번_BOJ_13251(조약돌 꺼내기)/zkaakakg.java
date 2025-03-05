import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		String[] input = br.readLine().split(" ");

		double result = 0.0;
		int k;
		
		int sum = 0;
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(input[i]);
			sum += arr[i];
		}
		
		k = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			result += combination(arr[i], k);
		}
		
		System.out.print(result/combination(sum,k));
		
	}
	public static double combination(int n, int r) {
		if(n == r || r == 0) return 1; 
		
		double temp = 1.0;
        for (int i = 0; i < r; i++) {
            temp *= (n - i);
            temp /= (i + 1);
        }
        return temp;
	}

}
