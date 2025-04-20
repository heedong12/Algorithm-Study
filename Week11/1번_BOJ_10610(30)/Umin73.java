package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class _10610 {

    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        char[] numArr = N.toCharArray();

        Arrays.sort(numArr);
        for(int i=0; i<numArr.length/2 ; i++){
            char temp = numArr[i];
            numArr[i] = numArr[numArr.length - i - 1];
            numArr[numArr.length - i - 1] = temp;
        }

        String maxNumStr = new String(numArr);
        BigInteger maxNum = new BigInteger(maxNumStr);

        if(maxNum.mod(BigInteger.valueOf(30)).equals(BigInteger.ZERO)) {
            System.out.println(maxNumStr);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}
