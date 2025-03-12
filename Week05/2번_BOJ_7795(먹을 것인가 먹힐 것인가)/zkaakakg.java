import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for(int tc = 0; tc < t; tc++){
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      int[] a = new int[n];
      int[] b = new int[m];

      input = br.readLine().split(" ");
      for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(input[i]);
      }

      input = br.readLine().split(" ");
      for(int i = 0; i < m; i++){
        b[i] = Integer.parseInt(input[i]);
      }

      Arrays.sort(b);
      int cnt = 0;
 
      for(int i = 0; i < n; i++){
        cnt += search(b, a[i]);
      }
      System.out.println(cnt);
    }
  }

  public static int search(int[] arr, int key){
    int start = 0;
    int end = arr.length;

    while (start < end) {
      int mid = (start + end) / 2;
      if(arr[mid] < key){
        start = mid + 1;
      }else {
        end = mid;
      }
    }
    return start;
  }
}
