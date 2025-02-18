import java.util.Scanner;

public class Main {

    // n   k
    //     1 2 3 4 5 ...
    // 1 = 1 2 3 4 ...
    // 2 = 1 3 6
    // 3 = 1 4 10
    // 4 = 1 5 15
    //arr[i][j]= arr[i-1][j] + arr[i][j-1];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[][] arr = new int[n+1][k+1];
        for(int i=1; i<=n; i++) {
            arr[i][1] = 1;
        }
        for(int i=1; i<=k; i++) {
            arr[1][i] = i;
        }

        for(int i=2; i<=n; i++) {
            for(int j=2; j<=k; j++) {
                arr[i][j]= (arr[i-1][j] + arr[i][j-1]) % 1000000000;
            }
        }
        System.out.println(arr[n][k]);
    }
}
