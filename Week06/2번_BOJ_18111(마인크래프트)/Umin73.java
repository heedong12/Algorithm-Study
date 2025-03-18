package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18111 {
    static int N, M, B;
    static int[][] arr;
    static int time = Integer.MAX_VALUE;
    static int highestFloor = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);
        arr = new int[N][M];

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0; i< N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] < low) low = arr[i][j];
                if(arr[i][j] > high) high = arr[i][j];
            }
        }

        for(int floor = high; floor >= low; floor--) {
            int tempTime = 0;
            int blockCnt = B;
            for(int i=0; i<N;i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] < floor) { // 현재 블록 층수가 floor보다 낮으면
                        blockCnt -= (floor - arr[i][j]); // 인벤토리에서 블록 꺼냄
                        tempTime += 1 * (floor - arr[i][j]);
                    } else if(arr[i][j] > floor) { // 현재 블록 층수가 floor보다 높으면
                        blockCnt += (arr[i][j] - floor); // 블록 제거 후 인벤토리에 넣음
                        tempTime += 2 * (arr[i][j] - floor);
                    }
                }
            }

            // 인벤토리에서 블럭 꺼내는게 문제 없었고
            // 기존에 저장된 시간보다 이번에 확인한 시간이 더 적게 걸리면
            if(blockCnt >= 0 && time > tempTime) {
                highestFloor = floor;
                time = tempTime;
            }
        }
        System.out.println(time + " " + highestFloor);

        br.close();
    }
}
