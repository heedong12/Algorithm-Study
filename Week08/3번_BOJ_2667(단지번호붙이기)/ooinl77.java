import java.io.*;
import java.util.*;


public class Main {
    static int house = 0; // 단지 내 갸구 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지도 크기
        int[][] map = new int[N][N]; // 지도
        int count = 0; // 총 단지 수
        ArrayList<Integer> houseArray = new ArrayList<>(); // 단지 내 가구 수 배열
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        boolean[][] visited = new boolean[N][N];

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (visited[j][k]) continue;
                dfs(j, k, map, visited, N);
                //집이 있는 땅에 다녀왔을 때
                if(house != 0) {
                    houseArray.add(house);
                    count++;
                    house = 0;
                }
            }
        }
        Collections.sort(houseArray);
        System.out.println(count);
        for(int i=0; i<houseArray.size(); i++) {
            System.out.println(houseArray.get(i));
        }

    }

    public static void dfs (int column, int row, int[][] map, boolean[][] visited, int N ) {
        // index 0 미만, 크기 초과 거르기
        if(column < 0 || column >= N) return;
        if(row < 0 || row >= N) return;
        // 집이 없다
        if(map[column][row] == 0) return;
        // 왔다감
        if(visited[column][row]) return;
        visited[column][row] = true;
        //집이 있다
        house++;
        //앞 뒤 양 옆 조사
        dfs(column + 1, row, map, visited, N);
        dfs(column - 1 , row, map, visited, N);
        dfs(column, row + 1, map, visited, N);
        dfs(column, row - 1 , map, visited, N);
    }
}