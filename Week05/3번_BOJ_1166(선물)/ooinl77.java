import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double left = 0; //최소
        double right = Math.min(L, Math.min(W, H)); //최대

        for(int i = 0; i < 10000; i++){
            double mid = (left + right) / 2;
            long  count = ((long) (L / mid)) * ((long) (W / mid)) * ((long) (H / mid));
            if ( count >=N ) {
                left = mid;  // 가능하면 더 큰 정육면체를 시도
            } else {
                right = mid; // 불가능하면 더 작은 정육면체를 시도
            }
        }
        System.out.printf("%.10f\n", left);
    }
}
