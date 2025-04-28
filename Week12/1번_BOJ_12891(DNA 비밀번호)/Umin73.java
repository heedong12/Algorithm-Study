package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12891 {

    static int S, P;
    static String DNA;
    static int[] minConditions;
    static int[] cntArr;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        S = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);

        DNA = br.readLine();

        cntArr = new int[4];
        minConditions = new int[4];
        input = br.readLine().split(" ");
        for(int i = 0; i < 4; i++){
            minConditions[i] = Integer.parseInt(input[i]);
        }

        int firstIdx = 0;
        int lastIdx = P;
        String tempPw = DNA.substring(firstIdx, lastIdx);
        for(char c : tempPw.toCharArray()) {
            if(c == 'A') cntArr[0]++;
            else if(c == 'C') cntArr[1]++;
            else if(c == 'G') cntArr[2]++;
            else if(c == 'T') cntArr[3]++;
        }
        while(lastIdx <= DNA.length()){
            if (cntArr[0] >= minConditions[0] && cntArr[1] >= minConditions[1]
                    && cntArr[2] >= minConditions[2] && cntArr[3] >= minConditions[3]) answer++;

            if(lastIdx == DNA.length()) break;

            char removeChar = DNA.charAt(firstIdx);
            if(removeChar == 'A') cntArr[0]--;
            else if(removeChar == 'C') cntArr[1]--;
            else if(removeChar == 'G') cntArr[2]--;
            else if(removeChar == 'T') cntArr[3]--;

            char addChar = DNA.charAt(lastIdx);
            if(addChar == 'A') cntArr[0]++;
            else if(addChar == 'C') cntArr[1]++;
            else if(addChar == 'G') cntArr[2]++;
            else if(addChar == 'T') cntArr[3]++;

            firstIdx++;
            lastIdx++;

        }
        System.out.println(answer);

        br.close();
    }
}
