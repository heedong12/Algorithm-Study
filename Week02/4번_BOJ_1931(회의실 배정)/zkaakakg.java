import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		
		for(int i=0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]); 
		}
		
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});;

		int end = 0;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}
		}
		
		System.out.print(cnt);
	}

}
