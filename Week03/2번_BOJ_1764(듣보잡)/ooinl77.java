import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//1. 해쉬셋에 듣도 못한 사람들 추가
//2. 보도 못한 사람들로 비교
//3. 트리셋에 듣보잡들 추가

public class ooinl77 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
        int result = 0; //듣보잡 수
        HashSet<String> nameSet = new HashSet<>(N); // 듣도 못한 사람들
        TreeSet<String> orderedNameSet = new TreeSet<>(); // 듣보잡들
        //초기화
        for(int i=0; i<N; i++) {
            nameSet.add(br.readLine());
        }
        //비교
        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if(nameSet.contains(name)){
                result++;
                orderedNameSet.add(name);
            }
        }
        //출력
        System.out.println(result);
        for(String i : orderedNameSet) {
            System.out.println(i);
        }
    }
}
