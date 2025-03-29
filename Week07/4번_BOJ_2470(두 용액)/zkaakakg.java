import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int left = 0, right = n-1;
        int isZero = Integer.MAX_VALUE;;
        int[] result = new int[2];
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(0 - sum) < isZero){
                isZero = Math.abs(0 - sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
