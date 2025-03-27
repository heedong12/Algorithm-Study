import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열 크기
        int[] seq = new int[n]; // 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine()); // 타겟
        int count = 0; // 결과

        //300ms
        HashSet<Integer> set = new HashSet<>(); //contains 사용 용도
        //두번 체크 방지를 위해 처음 원소들은 그냥 넣고, 다음 원소 중 포함되면 count 추가
        for (int num : seq) {
            if (set.contains(x - num)) {
                count++;
            } else {
                set.add(num);
            }
        }

        //344ms
//        int left = 0; // 왼쪽 포인터
//        int right = n-1; // 오른쪽 포인터
//
//        while(left < right){
//            int sum = seq[left] + seq[right];
//
//            if (sum == x) { // 합이 타겟이 되면 증가
//                count++;
//                left++;
//                right--;
//            } else if (sum > x) {
//                right--;
//            } else {
//                left++;
//            }
//        }

        System.out.println(count);
    }
}