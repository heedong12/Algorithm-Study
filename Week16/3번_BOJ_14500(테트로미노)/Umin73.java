package 백준;

import java.io.*;

public class _14500 {

    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int answer = 0;

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void checkSpecialShape(int x, int y) {
        for(int i=0; i<4; i++) {
            int sum = paper[y][x];
            boolean isValid = true;

            for(int j=0; j<3; j++) {
                int dirIdx = (i+j)%4;
                int nextX = x + dirs[dirIdx][1];
                int nextY = y + dirs[dirIdx][0];

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                    isValid = false;
                    break;
                }
                sum += paper[nextY][nextX];
            }
            if(isValid) answer = Math.max(sum, answer);
        }
    }

    static void solution(int x, int y, int sum, int depth) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int[] dir : dirs) {
            int nextX = x + dir[1];
            int nextY = y + dir[0];

            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
            if(visited[nextY][nextX]) continue;

            visited[nextY][nextX] = true;
            solution(nextX, nextY, sum+paper[nextY][nextX], depth + 1);
            visited[nextY][nextX] = false;
        }

        if(depth ==1) checkSpecialShape(x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N][M];
        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                solution(j, i,paper[i][j],1);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
