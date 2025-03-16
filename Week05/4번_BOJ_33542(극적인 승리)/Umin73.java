package 백준;

import java.io.*;
import java.util.*;

public class _33542 {
    static long A, B, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);

        long bestScore = A - B + 1; // 가장 극적으로 이길 수 있는 점수
        if (bestScore <= 0) { // 이미 이긴 경우
            System.out.println("-1 -1");

            br.close();
            return;
        }

        N = Integer.parseInt(br.readLine());
        List<int[]> l = new ArrayList<>(); // {왼손점수값, 왼손점수인덱스}
        List<int[]> r = new ArrayList<>();

        long diff = Long.MAX_VALUE;
        int[] answer = {-1, -1};

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int leftValue = Integer.parseInt(input[0]);
            int rightValue = Integer.parseInt(input[1]);

            l.add(new int[]{leftValue, i});
            r.add(new int[]{rightValue, i});

            // 한 손으로 이기는지?
            if (leftValue >= bestScore && diff > leftValue - bestScore) {
                diff = leftValue - bestScore;
                answer = new int[]{i + 1, -1};
            }
            if (rightValue >= bestScore && diff > rightValue - bestScore) {
                diff = rightValue - bestScore;
                answer = new int[]{-1, i + 1};
            }
        }

        l.sort(Comparator.comparingInt(o -> o[0]));
        r.sort(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < N; i++) {
            int firstValue = l.get(i)[0];
            int firstIndex = l.get(i)[1];

            int first = 0, last = (int) (N - 1);
            while (first <= last) {
                int mid = (first + last) / 2;
                int secondIndex = r.get(mid)[1];
                int secondValue = r.get(mid)[0];

                long value = firstValue + secondValue;

                if (secondIndex == firstIndex) {
                    if (first == last) break;
                    mid++;
                    if (mid >= N) break;
                    secondIndex = r.get(mid)[1];
                    secondValue = r.get(mid)[0];
                    value = firstValue + secondValue;
                }

                if (value == bestScore) {
                    System.out.println((firstIndex + 1) + " " + (secondIndex + 1));
                    return;
                } else if (value < bestScore) {
                    first = mid + 1;
                } else {
                    if (diff > value - bestScore) {
                        diff = value - bestScore;
                        answer = new int[]{firstIndex + 1, secondIndex + 1};
                    }
                    last = mid - 1;
                }
            }
        }

        if (answer[0] == -1 && answer[1] == -1) {
            System.out.println("No");
        } else {
            System.out.println(answer[0] + " " + answer[1]);
        }
        br.close();
    }
}