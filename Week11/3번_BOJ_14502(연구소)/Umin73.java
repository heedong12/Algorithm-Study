package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _14502 {

    static int N, M;
    static int answer = 0;
    static int[][] arr;

    static List<Position> virusPosList;
    static List<Position> safePosList;

    // 상하좌우
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static class Position {
        int x, y;
        public Position(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    // 1. 벽 세우기
    static void solution1() {
        // 아직 안전한 영역(0)만 감염될 수 있는 가능성 있음
        for(int i=0; i<safePosList.size()-2; i++) {
            for(int j=i+1; j<safePosList.size()-1; j++) {
                for(int k=j+1; k<safePosList.size(); k++) {
                    Position a = safePosList.get(i);
                    Position b = safePosList.get(j);
                    Position c = safePosList.get(k);

                    // 벽 세우기
                    arr[a.y][a.x] = 1;
                    arr[b.y][b.x] = 1;
                    arr[c.y][c.x] = 1;

                    solution2();

                    arr[a.y][a.x] = 0;
                    arr[b.y][b.x] = 0;
                    arr[c.y][c.x] = 0;
                }
            }
        }

    }

    // 2. 감염시키기
    static void solution2() {
        List<Position> infected = new ArrayList<>();
        Queue<Position> queue = new LinkedList<>(); // 바이러스 위치 저장
        for(Position virusPos : virusPosList) {
            queue.offer(virusPos);
        }

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i <4; i++) {
                int nextX = pos.x + dirX[i];
                int nextY = pos.y + dirY[i];
                if(nextX >= 1 && nextX <= M && nextY >= 1 && nextY <= N) {
                    if(arr[nextY][nextX] == 0) {
                        arr[nextY][nextX] = -1;
                        infected.add(new Position(nextY, nextX));
                        queue.offer(new Position(nextY, nextX));
                    }
                }
            }
        }

        // 안전영역 크기 구하기
        int safeZone = safePosList.size() - infected.size() - 3;
        answer = Math.max(safeZone, answer);
        for(Position infectedPos : infected) {
            arr[infectedPos.y][infectedPos.x] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 세로
        M = Integer.parseInt(input[1]); // 가로
        arr = new int[N+2][M+2];

        safePosList = new ArrayList<>();
        virusPosList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
                if(arr[i][j] == 0) safePosList.add(new Position(i,j));
                if(arr[i][j] == 2) virusPosList.add(new Position(i,j));
            }
        }

        solution1();

        System.out.println(answer);

        br.close();
    }
}
