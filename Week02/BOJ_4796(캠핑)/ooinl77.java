import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = 1;

        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]); // 사용 가능한 일수
            int P = Integer.parseInt(input[1]); // 연속 사용 가능한 일수
            int V = Integer.parseInt(input[2]); // 총 휴가 일수

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int result = (V / P) * L;
            if((V % P) > L) {
                result += L;
            } else {
                result += (V % P);
            }

            System.out.println("Case " + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}