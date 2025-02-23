import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수
        int[][] time = new int[N][2]; // 회의 시간 배열

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String[] timeInput = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(timeInput[0]); // 시작 시간
            time[i][1] = Integer.parseInt(timeInput[1]); // 종료 시간
        }

        // 종료 시간 기준 오름차순 정렬 (종료 시간이 같으면 시작 시간 기준 오름차순 정렬)
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int endTime = 0; // 현재 회의가 끝나는 시간
        int result = 0;  // 최대 회의 수

        // 그리디 알고리즘 적용
        for (int i = 0; i < N; i++) {
            // 현재 회의의 시작 시간이 마지막으로 선택된 회의의 종료 시간 이후라면 선택 가능
            if (time[i][0] >= endTime) {
                result++;
                endTime = time[i][1]; // 현재 회의의 종료 시간을 갱신
            }
        }

        System.out.println(result);
    }
}
