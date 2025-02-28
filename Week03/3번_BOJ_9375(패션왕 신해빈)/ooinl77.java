import java.io.*;
import java.util.*;

// 종류별 갯수 카운트
// 종류별로 안입는경우 1개 더해야하네
// 전부 곱하고 아무것도 안입는 경우 1개 빼야하네


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 수

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 의상 수
            HashMap<String, Integer> dressMap = new HashMap<>(N);
            int result = 1; // 경우의 수
            // Map 초기화
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String dress = st.nextToken();
                String dressCategory = st.nextToken();
                if(dressMap.containsKey(dressCategory)){
                    dressMap.put(dressCategory, dressMap.get(dressCategory) + 1);
                }else {
                    dressMap.put(dressCategory, 1);
                }
            }
            for(int count : dressMap.values()) {
              result *= count+1;
            }
        System.out.println(result -1);
        }


    }
}
