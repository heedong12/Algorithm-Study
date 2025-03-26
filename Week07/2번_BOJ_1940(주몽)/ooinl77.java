import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료 수
        int M = Integer.parseInt((br.readLine())); // 갑옷 제작 번호
        int[] materials = new int[N]; // 재료 번호
        int count = 0; // 갑옷 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int left = 0; // 왼쪽 포인터
        int right = N - 1; // 오른쪽 끝 포인터

        while (left < right) {
            int sum = materials[left] + materials[right]; // 재료 번호 합이

            if (sum == M) { // 제작번호랑 같을 때, 개수 증가, 포인터 둘 다 갱신
                count++;
                left++;
                right--;
            } else if (sum > M) { // 번호보다 크면 오른쪽 감소
                right--;
            } else { // 번호보다 작으면 왼쪽 증가
                left++;
            }
        }
        System.out.println(count);
    }


}