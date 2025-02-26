import java.io.*;
import java.util.*;

public class _1764 {
    static int N, M;
    static Set<String> set = new HashSet<String>();
    static TreeSet<String> answer = new TreeSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            String name = br.readLine();
            set.add(name);
        }
        for(int i=0;i<M;i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                answer.add(name);
            }
        }

        bw.write(answer.size() + "\n");
        for(String s : answer) {
            bw.write(s + "\n");
        }

        br.close();
        bw.close();
    }
}
