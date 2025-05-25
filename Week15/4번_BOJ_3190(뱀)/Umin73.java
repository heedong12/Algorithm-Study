package 백준;

import java.io.*;
import java.util.*;

public class _3190 {

    static int N, K, L;
    static boolean[][] apple;
    static Deque<int[]> snake;
    static boolean[][] isSnakePos;
    static int[] dirChange;
    static int curSec = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 보드 크기
        K = Integer.parseInt(br.readLine()); // 사과의 개수

        isSnakePos = new boolean[N+1][N+1];
        apple = new boolean[N+1][N+1];
        for(int i=0; i<K; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            apple[y][x] = true;
        }

        L = Integer.parseInt(br.readLine());
        dirChange = new int[10001];
        for(int i=0; i<L; i++) {
            String[] input = br.readLine().split(" ");
            int sec = Integer.parseInt(input[0]);
            dirChange[sec] = input[1].equals("L") ? -1 : 1;
        }

        snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1, 1});
        isSnakePos[1][1] = true;

        // 위, 오른, 아래, 왼
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int curDirIdx = 1;

        while(true) {

            curSec++;

            int[] snakeHead = snake.peekFirst();
            int nextY = snakeHead[0] + dir[curDirIdx][0];
            int nextX = snakeHead[1] + dir[curDirIdx][1];

            // 벽 or 자기 몸에 부딪히면 게임 종료
            if(nextX < 1 || nextX > N || nextY < 1 || nextY > N || isSnakePos[nextY][nextX]) break;

            // 뱀 머리 다음 위치로 땡기기
            snake.addFirst(new int[]{nextY, nextX});
            isSnakePos[nextY][nextX] = true;

            // 다음 위치에 사과 있는지 확인
            if(apple[nextY][nextX]) {
                apple[nextY][nextX] = false; // 먹었으니 false 처리
            } else {
                int[] tail = snake.removeLast(); // 사과 안먹었으면 마지막 꼬리 위치 칸 비우기
                isSnakePos[tail[0]][tail[1]] = false;
            }

            if(dirChange[curSec] != 0) { // 현재 초에 방향 전환할 게 있으면 방향 돌리기
                curDirIdx = (curDirIdx + dirChange[curSec] + 4)% 4;
            }
        }
        System.out.println(curSec);

        br.close();
    }
}
