// 1.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        A = new BigInteger(input[0]);
        B = new BigInteger(input[1]);
        C = new BigInteger(input[2]);

        System.out.println(A.modPow(B,C));

        br.close();
    }
}

// 2.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static long A, B, C;

    static long myPow(long a, long b) {
        long answer = 1;

//        10^11 == (10^5)^2*a
//        10^10 == (10^5)^2
        while(b>0) {
            if(b%2==1) {
                answer = answer * a % C;
            }
            a = (a*a)%C;
            b /= 2;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);

        if(A == 0) System.out.println(0);
        else if(B == 0) System.out.println(A%C);
        else System.out.println(myPow(A,B));

        br.close();
    }
}

