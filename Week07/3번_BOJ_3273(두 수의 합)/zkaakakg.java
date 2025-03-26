import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(input[i]);
    }
    
    int x = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();


    int cnt = 0;
    // int left = 0; int right = n-1;
    
    // Arrays.sort(arr);
    // while (left<right){
    //   int sum = arr[left] + arr[right];
    //   if(sum == x){
    //     cnt++;
    //     right--;
    //     left++;
    //   }else if(sum < x){
    //     left++;
    //   }else{
    //     right--;
    //   }
    // }

    for (int num : arr) {
      int complement = x - num; 
    
      if (map.getOrDefault(complement, 0) > 0) {
        cnt++;
        map.put(complement, map.get(complement) - 1);
      } else {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }

    System.out.println(cnt);
  }
}
