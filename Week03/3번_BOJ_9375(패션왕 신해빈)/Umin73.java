import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9375 {
    static int T;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<String, Integer>();

            for(int j=0;j<n;j++){
                String[] input = br.readLine().split(" ");
                String type = input[1];

                map.put(type, map.getOrDefault(type,0)+1);
            }

            int answer = 1;
            for(int cnt:map.values()){
                answer *= (cnt+1);
            }
            answer -= 1;

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
