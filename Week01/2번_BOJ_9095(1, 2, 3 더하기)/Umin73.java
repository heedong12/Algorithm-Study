import java.io.*;

public class _9095 {
    static int T, N;
    static int[] arr = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr[0] = 1; // 1
        arr[1] = 2; // 1+1, 2
        arr[2] = 4; // 1+1+1, 2+1, 3, 1+2

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solution(N-1)));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int idx) {
        if(arr[idx] == 0) {
            arr[idx] = solution(idx-1) + solution(idx-2) + solution(idx-3);
        }
        return arr[idx];
    }
}