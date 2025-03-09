import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 상근이 CD 
            int M = Integer.parseInt(st.nextToken()); // 선영이 CD 

            if (N == 0 && M == 0) break; 

            HashSet<Integer> CD = new HashSet<>();
            int count = 0;

            for (int i = 0; i < N; i++) {
                CD.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < M; i++) {
                if (CD.contains(Integer.parseInt(br.readLine()))) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
