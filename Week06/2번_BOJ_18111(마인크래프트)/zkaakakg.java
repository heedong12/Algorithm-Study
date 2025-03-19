import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input  = br.readLine().split(" ");
		
	
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int b = Integer.parseInt(input[2]);
		int[][] arr= new int[n][m];  // 땅 높이 배열

		int minHeight = 0; 
		int maxHeight = 0; 

		for(int i = 0; i < n; i++) {   
			input  = br.readLine().split(" ");
			for(int j= 0; j <m; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				maxHeight = Math.max(maxHeight, arr[i][j]); // 땅의 최소 높이
				minHeight = Math.min(minHeight, arr[i][j]); // 땅의 최대 높이
			}
		}
		
		int minTime = Integer.MAX_VALUE; // 땅 고르기 최소 시간
		int targetHeight = 0; // 목표 땅의 높이

		// minHeight부터 maxHeight까지 탐색
		for(int i = minHeight; i <= maxHeight; i++) {
			int time = 0;
			int inventory = b;
			
			for(int x = 0; x <n; x++) {
				for(int y = 0; y < m; y++) {
					int diff = arr[x][y] - i; // 현재 블록과 목표 높이의 차이
					
					if(diff > 0) { // 현재 높이가 목표 높이보다 높은 경우 블록제거 
						time += diff*2; // 제거 시 2초 소요
						inventory += diff; // 제거한 블록 인벤토리에 추가
					} else if(diff < 0) { // 현재 높이가 목표 높이보다 낮은 경우 블록 추가
						time += -diff; // 추가 시 1초 소요
						inventory += diff; // 인벤토리에서 블록 사용
					}
				}
			}
			
			// 인벤토리가 0 이상이고  최소 시간일 경우 갱신
			if(inventory >= 0 && time <= minTime) {
				minTime = time;
				targetHeight = i;
			}
		}
		
		
		System.out.print(minTime + " " +targetHeight);
	}
}

