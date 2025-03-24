import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //숫자 개수
        int M = Integer.parseInt(st.nextToken()); //타겟
        int sum = 0; // 합계산
        int count = 0; // 결과
        List<Integer> li = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            li.add(Integer.parseInt(st.nextToken()));
        }

        int left = 0; // 왼쪽 포인터
        int right = 0; // 오른쪽 포인터

        while(right < li.size()){
            sum += li.get(right++); // 오른쪽 포인터를 늘리면서 더하기

            while (sum > M) { // M보다 커지면 왼쪽 포인터 이동하고, 빼기
                sum -= li.get(left++);
            }

            if (sum == M) { // 합이 타겟이 되면 증가
                count++;
            }
        }
        System.out.println(count);
    }
}