import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Dong = Integer.parseInt(st.nextToken()); // 동현이
        int Ju = Integer.parseInt(st.nextToken()); // 주원이
        int N = Integer.parseInt(br.readLine()); // 과녁 개수

        // 주원이가 이긴다
        if (Ju > Dong) {
            System.out.println("-1 -1");
            return;
        }

        int minPoint = Dong - Ju + 1; // 최소 점수차
        int[][] targets = new int[N + 1][2];  

        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            targets[i][0] = Integer.parseInt(st.nextToken()); // 왼쪽 점수
            targets[i][1] = Integer.parseInt(st.nextToken()); // 오른쪽 점수
        }

        int[][] rightScores = new int[N][2]; 

      
        for (int i = 0; i < N; i++) {
            rightScores[i][0] = targets[i + 1][1]; 
            rightScores[i][1] = i + 1;       
        }


        Arrays.sort(rightScores, Comparator.comparingInt(o -> o[0]));

        int x = -1, y = -1;
        int minScore = Integer.MAX_VALUE;

   
        for (int i = 1; i <= N; i++) {
            int leftScore = targets[i][0];
            if (leftScore >= minPoint && leftScore < minScore) {
                minScore = leftScore;
                x = i;
                y = -1; 
            }

            int rightScore = targets[i][1];
            if (rightScore >= minPoint && rightScore < minScore) {
                minScore = rightScore;
                x = -1;
                y = i; 
            }

     
            int remainingTarget = minPoint - leftScore;
            if (remainingTarget <= 0) continue;

            int idx = binarySearch(rightScores, remainingTarget);

            if (idx >= N) continue;

            int right = rightScores[idx][1];
            if (i == right) {
                idx++;
                if (idx >= N) continue;

                right = rightScores[idx][1];

                if (i == right) continue;
            }

            int totalScore = leftScore + rightScores[idx][0];
            if (totalScore < minScore) {
                minScore = totalScore;
                x = i;
                y = right;
            }
        }


        if (minScore == Integer.MAX_VALUE) {
            System.out.println("No");
        } else {
            System.out.println(x + " " + y);
        }
    }


    public static int binarySearch(int[][] arr, int target) {
        int start = 0, end = arr.length - 1; 
        while (start <= end) { 
            int mid = (start + end) / 2;
            if (arr[mid][0] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
