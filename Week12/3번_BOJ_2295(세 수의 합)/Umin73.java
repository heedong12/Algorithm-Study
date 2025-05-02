package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2295 {

    static int N;
    static List<Integer> U;
    static Set<Integer> sumOfTwoNums;
    static int answer = 0;

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumOfTwoNums.add(U.get(i) + U.get(j));
            }
        }

        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                if(sumOfTwoNums.contains(U.get(i) - U.get(j))) {
                    answer = U.get(i);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        U = new ArrayList<>();
        sumOfTwoNums = new HashSet<>();

        for (int i = 0; i < N; i++) {
            U.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(U);

        solution();

        System.out.println(answer);

        br.close();
    }
}
