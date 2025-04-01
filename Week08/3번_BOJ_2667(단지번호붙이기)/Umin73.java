package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0; // 단지 수
    static List<Integer> homeCntList = new ArrayList<>();

    static void dfs(int i, int j, int listIdx) {
        if(visited[i][j]) return;

        if(map[i][j] == 1) {
            visited[i][j] = true;
            homeCntList.set(listIdx, homeCntList.get(listIdx)+1);
            if(i > 0 && i <= N && j > 0 && j <= N) {
                dfs(i+1, j, listIdx);
                dfs(i-1, j, listIdx);
                dfs(i, j+1, listIdx);
                dfs(i, j-1, listIdx);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2];
        visited = new boolean[N+2][N+2];
        for(int i=1;i<=N;i++) {
            String input = br.readLine();
            for(int j=1; j<=N; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        int listIdx = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    homeCntList.add(0);
                    dfs(i, j, listIdx++);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(cnt);
        Collections.sort(homeCntList);
        for (int l : homeCntList) {
            answer.append("\n").append(l);
        }
        System.out.println(answer);

        br.close();
    }
}
