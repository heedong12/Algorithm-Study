import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

    static int[][][] tetromino = {
            // ㅡ, ㅣ
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},

            // 정사각형
            {{0,0},{0,1},{1,0},{1,1}},

            // ㄴ자 회전들
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{1,0},{2,0},{2,-1}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,0},{0,1},{0,2},{1,0}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,0},{0,1},{0,2},{-1,2}},
            {{0,0},{1,0},{1,1},{1,2}},

            // 번개 모양
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,0},{1,0},{1,-1},{2,-1}},
            {{0,0},{0,1},{1,1},{1,2}},
            {{0,0},{0,-1},{1,-1},{1,-2}},

            // ㅗ자
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,0},{1,-1},{1,0},{1,1}},
            {{0,0},{1,0},{2,0},{1,-1}},
            {{0,0},{1,0},{1,1},{2,0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int[][] shape : tetromino) {
                    int sum = 0;
                    boolean isValid = true;

                    for(int[] block : shape) {
                        int x = i + block[0];
                        int y = j + block[1];

                        if(x < 0 || x >= N || y < 0 || y >= M) {
                            isValid = false;
                            break;
                        }

                        sum += map[x][y];
                    }

                    if(isValid) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}