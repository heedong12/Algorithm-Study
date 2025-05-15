package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _3085 {

    static int N;
    static char[][] arr;
    static int answer = 0;

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static void calcRowContinuousPart(int row) {
        int continuous = 1;
        for (int j = 1; j < N; j++) {
            if (arr[row][j] == arr[row][j - 1]) continuous++;
            else continuous = 1;
            answer = Math.max(answer, continuous);
        }
    }

    static void calcColContinuousPart(int col) {
        int continuous = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i][col] == arr[i - 1][col]) continuous++;
            else continuous = 1;
            answer = Math.max(answer, continuous);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j+1 < N) {
                    swap(i,j, i,j+1);
                    calcRowContinuousPart(i);
                    calcColContinuousPart(j);
                    calcColContinuousPart(j+1);
                    swap(i,j,i,j+1);
                }
                if(i+1 < N) {
                    swap(i,j,i+1,j);
                    calcRowContinuousPart(i);
                    calcRowContinuousPart(i+1);
                    calcColContinuousPart(j);
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(answer);

        br.close();
    }
}
