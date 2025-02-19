import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinCount = 0; // 동전 개수
        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 가치의 합
        int[] coinArr = new int[N]; // 오름차순 동전 배열
        int coinArrIndex = 0; // K보다 작은 동전 중 최댓값 인덱스

        for (int i = 0; i < N; i++) {
            int coinVal = Integer.parseInt(br.readLine()); // 동전의 가치
            if (coinVal <= K) {
                coinArr[i] = coinVal;
                coinArrIndex = i;
            } else {
                break;
            }
        }
        for (int i = coinArrIndex; i >= 0 ; i--) {
            coinCount += (K / coinArr[i]);
            K = (K % coinArr[i]);
        }
        System.out.println(coinCount);
    }
}