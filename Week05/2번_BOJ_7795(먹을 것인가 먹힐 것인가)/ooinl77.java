import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            int count = 0;

            for (int a : A) {
                int left = 0;
                int right = M - 1;
                while(left <= right) {
                    int mid = (left+right) / 2;

                    if(B[mid] < a) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += left;

            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}