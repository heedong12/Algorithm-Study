import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int n = Integer.parseInt(br.readLine());
        
        if (a < b) {
            System.out.println("-1 -1");
            return;
        }
        
        int targetScore = a - b + 1;
        int[][] targets = new int[n + 1][2];

        for (int i = 1; i <=n; i++) {
            input = br.readLine().split(" ");
            targets[i][0] = Integer.parseInt(input[0]);
            targets[i][1] = Integer.parseInt(input[1]);
        }
        
        int[][] rightScores = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            rightScores[i][0] = targets[i+1][1];
            rightScores[i][1] = i+1;
        }
        Arrays.sort(rightScores, Comparator.comparingInt(o -> o[0]));
  
        int x = -1, y = -1;
        int minScore = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int score = targets[i][0];
            if (score >= targetScore && score < minScore) {
                minScore = score;
                x = i;
                y = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            int score = targets[i][1];
            if (score >= targetScore && score < minScore) {
                minScore = score;
                x = -1;
                y = i;
            }
        }
       
       
        for (int i = 1; i <= n; i++) {
            int leftScore = targets[i][0];
            
            int remainingTarget = targetScore - leftScore;
            if (remainingTarget <= 0) continue;
            
            int idx = search(rightScores, remainingTarget);
            
            if(idx >= n) continue;
            
            int rightScore = rightScores[idx][0];
            int right = rightScores[idx][1];
            
            if (i == right) {
                idx++;
                if (idx >= n) continue;
                
                rightScore = rightScores[idx][0];
                right = rightScores[idx][1];
                
                if (i == right) continue;
            }
            
            int totalScore = leftScore + rightScore;
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

    public static int search(int[][] arr, int target) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid =  start + (end - start) / 2;
            
            if (arr[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
}
