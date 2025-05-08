// 1번 (440ms)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MAX = 0;
    static long[] fArr;
    static long[] gArr;
    static int[] nArr;

    static void setArrF() {
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j+=i) {
                fArr[j] += i;
            }
        }
    }

    static void setArrG() {
        for (int i = 1; i <= MAX; i++) {
            gArr[i] = fArr[i] + gArr[i-1];
        }
    }
    // g(N)을 구하는 문제
    // g(N) = f(N) + f(N-1) + f(N-2) + .... + f(1)

    /*
     * g(0) = 0
     * g(1) = f(1) + g(0) = 1
     * g(2) = f(2) + g(1) = 1+2+1 = 4
     * g(3) = f(3) + g(2) = 1+3+4 = 8
     * g(4) = f(4) + g(3) = 1+2+4 + 8 = 15
     * g(5) = f(5) + g(4) = 1+5+ 15 = 21
     * g(6) = f(6) + g(5) = 1+2+3+6 + 21 = 33
     * g(7) = f(7) + g(6) = 1+7+ 33 =41
     * g(8) = f(8) + g(7) = 1+2+4+8 + 41 = 56
     * g(9) = f(9) + g(8) = 1+3+9 + 56 = 69
     * g(10) = f(10) + g(9) = 1+2+5+10 = 69 = 87
     * */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        nArr = new int[T];
        for(int i=0; i<T; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
            if(nArr[i] > MAX) MAX = nArr[i];
        }

        fArr = new long[MAX+1];
        gArr = new long[MAX+1];
        setArrF();
        setArrG();
        for(Integer n : nArr) {
            sb.append(gArr[n]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}

//2번 (396ms)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MAX = 1000001;
    static long[] fArr = new long[MAX+1];
    static long[] gArr = new long[MAX+1];

    static void setArrF() {
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j+=i) {
                fArr[j] += i;
            }
        }
    }

    static void setArrG() {
        for (int i = 1; i <= MAX; i++) {
            gArr[i] = fArr[i] + gArr[i-1];
        }
    }
    // g(N)을 구하는 문제
    // g(N) = f(N) + f(N-1) + f(N-2) + .... + f(1)

    /*
     * g(0) = 0
     * g(1) = f(1) + g(0) = 1
     * g(2) = f(2) + g(1) = 1+2+1 = 4
     * g(3) = f(3) + g(2) = 1+3+4 = 8
     * g(4) = f(4) + g(3) = 1+2+4 + 8 = 15
     * g(5) = f(5) + g(4) = 1+5+ 15 = 21
     * g(6) = f(6) + g(5) = 1+2+3+6 + 21 = 33
     * g(7) = f(7) + g(6) = 1+7+ 33 =41
     * g(8) = f(8) + g(7) = 1+2+4+8 + 41 = 56
     * g(9) = f(9) + g(8) = 1+3+9 + 56 = 69
     * g(10) = f(10) + g(9) = 1+2+5+10 = 69 = 87
     * */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        setArrF();
        setArrG();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(gArr[N]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
