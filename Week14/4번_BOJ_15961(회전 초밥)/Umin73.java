package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15961_2 {

    static int N, D, K, C;
    static int[] conveyorBeltSushi;
    static int[] sushiCntArr;
    static int sushiType = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 총 접시 수
        D = Integer.parseInt(input[1]); // 초밥의 가짓 수
        K = Integer.parseInt(input[2]); // 연속해서 먹는 접시 수
        C = Integer.parseInt(input[3]); // 쿠폰 번호(공짜로 먹을 수 있는 초밥)

        conveyorBeltSushi = new int[N*2];
        sushiCntArr = new int[D+1];
        for(int i = 0; i < N; i++) {
            conveyorBeltSushi[i] = conveyorBeltSushi[N+i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<K;i++) {
            sushiCntArr[conveyorBeltSushi[i]]++;
            if(sushiCntArr[conveyorBeltSushi[i]] == 1) sushiType++;
        }
        answer = sushiCntArr[C] == 0
                ? Math.max(answer, sushiType+1)
                : Math.max(answer, sushiType);

        for(int i=1; i<=N; i++) {
            int removeSushi = conveyorBeltSushi[i-1];
            int addSushi = conveyorBeltSushi[i+K-1];

            sushiCntArr[removeSushi]--;
            if(sushiCntArr[removeSushi] == 0) sushiType--;

            sushiCntArr[addSushi]++;
            if(sushiCntArr[addSushi] == 1) sushiType++;

            answer = sushiCntArr[C] == 0
                    ? Math.max(answer, sushiType+1)
                    : Math.max(answer, sushiType);
        }

        System.out.println(answer);

        br.close();
    }
}
