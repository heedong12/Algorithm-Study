package 백준;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class _2331 {
    static int A, P;
    static int answer = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    static int getNextNum(int curNum) {
        int nextNum = 0;

        while(curNum > 0) {
            int part = curNum % 10;
            nextNum += (int) Math.pow(part, P);
            curNum /= 10;
        }

        return nextNum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);

        int curNum = A;
        int order = 1;
        map.put(curNum, order++);
        while(true) {
            int nextNum = getNextNum(curNum);
            if(!map.containsKey(nextNum)) {
                map.put(nextNum, order++);
                curNum = nextNum;
            } else {
                answer = map.get(nextNum)-1;
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
