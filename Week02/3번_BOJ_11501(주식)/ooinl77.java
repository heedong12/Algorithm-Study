import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            int day = Integer.parseInt(br.readLine()); // 날짜 수
            int[] valueArr = new int[day]; // 주가 저장 배열
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < day; i++) {
                valueArr[i] = Integer.parseInt(st.nextToken()); // 주가 저장
            }

            int maxValue = 0; // 최댓값
            int profit = 0; // 총 이익

            // 뒤에서부터 최댓값 갱신하며 비교
            for (int i = day - 1; i >= 0; i--) {
                // 1. 주가가 최댓값보다 크면 갱신
                if (valueArr[i] > maxValue) {
                    maxValue = valueArr[i];
                } else { // 2. 주가가 최댓값보다 작거나 같으면 이익 계산
                    profit += maxValue - valueArr[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb.toString());
    }

}