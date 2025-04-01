import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i =0; i <n;i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    list.add(dfs(i,j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int count : list) {
            System.out.println(count);
        }
    }

    public static int dfs(int x, int y) {
        if(x < 0 || y < 0 || x >= n || y >= n || arr[x][y] == 0) {
            return 0;
        }
        arr[x][y] = 0;
        int count = 1;
        for(int i = 0; i < 4 ; i++) {
            count += dfs(x+dx[i], y+dy[i]);
        }
        return count;
    }
}
