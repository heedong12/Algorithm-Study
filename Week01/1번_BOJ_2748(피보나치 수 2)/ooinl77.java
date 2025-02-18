import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1 {

    public static long fibo_b(int num) {

        long[] fibo_list = new long[num + 1];
        fibo_list[0] = 0;
        fibo_list[1] = 1;

        for(int i=2; i<=num; i++) {
            fibo_list[i] = fibo_list[i-1] + fibo_list[i-2];
        }

        return fibo_list[num];
    }

    //피보나치 수열 top-down
    //재귀, 메모이제이션
//    static Map<Integer, Long> memo = new HashMap<>();
//    public static long fibo_t(int num) {
//        //기본 반환형
//        if(num<=1) return num;
//        //연산 횟수 줄이기
//        if(memo.containsKey(num)) return memo.get(num);
//
//        long fibo = fibo_t(num-1) + fibo_t(num-2);
//        memo.put(num, fibo);
//        return fibo;
//
//    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibo_b(n));
//        System.out.println(fibo_t(n));
    }
}