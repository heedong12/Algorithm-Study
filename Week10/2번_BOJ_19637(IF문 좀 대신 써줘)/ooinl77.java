import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int N = Integer.parseInt(st.nextToken()); //칭호 개수
        int M = Integer.parseInt(st.nextToken()); //캐릭터 개수
        TreeMap<Integer, String> info = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if(!info.containsKey(power)){
                info.put(power, title);
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int charPower = Integer.parseInt(br.readLine());
            //charPower보다 크거나 같은 키 값 중 가장 작은 키 값을 반환
            int key = info.ceilingKey(charPower);
            sb.append(info.get(key)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
