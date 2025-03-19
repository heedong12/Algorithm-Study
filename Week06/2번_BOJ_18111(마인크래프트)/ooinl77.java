import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int B = Integer.parseInt(st.nextToken()); //블럭수
        int[][] ground = new int[N][M];
        int minHeight = 256; // 최소높이
        int maxHeight = 0; // 최대높이
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                int height = Integer.parseInt(st.nextToken()); //분기높이
                ground[i][j] = height; //땅 높이 초기화
                if(minHeight > height) minHeight = height; //최소높이설정
                if(maxHeight < height) maxHeight = height; //최대높이설정
            }
        }

        int minTime = Integer.MAX_VALUE; //최소시간
        int height = 0; // 최소시간의 최대높이

        for(int t=minHeight; t<=maxHeight; t++) {
            int rmBlock = 0; // 땅이 높아서 제거함
            int addblock = 0; // 땅이 낮아서 더해야함
            //땅고르기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diffHeight = ground[i][j] - t; // 높이차이
                    if (diffHeight > 0) { // 땅 파기
                        rmBlock += diffHeight;
                    } else if (diffHeight < 0) { // 땅 매우기
                        addblock -= diffHeight;
                    }
                }
            }

            //시간 계산
            if(B + rmBlock >= addblock) {
                int time = rmBlock * 2 + addblock;

                if(minTime > time) {
                    minTime = time;
                    height = t;
                }   else if (minTime == time) { //최대높이설정
                    height = t;
                }
            }
        }
        System.out.println(minTime + " " + height);
    }
}