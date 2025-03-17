import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[][] data = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            int weight = data[i][0];
            int height = data[i][1];
            int count = 0;

            for(int j=0; j<N; j++){
                if(i == j) {
                    continue;
                }
                if(weight < data[j][0] && height < data[j][1]){
                    count++;
                }
            }
            sb.append(count+1).append(" ");

        }
        System.out.println(sb.toString());
    }
}
