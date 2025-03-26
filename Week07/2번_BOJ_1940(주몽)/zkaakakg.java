import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");
    for(int i  = 0; i < n; i++){
      arr[i] = Integer.parseInt(input[i]);
    }

    int cnt = 0;
    int left = 0, right = n-1;
    Arrays.sort(arr);
    while(left < right){
      int sum = arr[left] + arr[right];
      if(sum == m){
        cnt++;
        left++;
        right--;
      }else if(sum < m){
        left++;
      }else{
        right--;
      }
    }
    System.out.println(cnt);
  }
}
