import java.io.*;
import java.util.*;

public class Main {
    static int a, p;
    static List<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        p = Integer.parseInt(input[1]);
        list  = new ArrayList<>();

        list.add(a);
        System.out.println(solution(a));
    }
    public static int solution(int a){
        int temp = 0;
        while(a > 0){
            int digit = a % 10;
            temp += Math.pow(digit,p);
            a /= 10;
        }
        if(list.contains(temp)){
            return list.indexOf(temp);
        }
        list.add(temp);
        return solution(temp);
    }
}
