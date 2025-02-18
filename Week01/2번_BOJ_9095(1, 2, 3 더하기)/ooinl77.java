import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    //1 = 1
    //2 = 2
    //3 = 4
    //4 = 7
    //5 = 13
    //6 = 24
    //arr[i] = arr[i-1] + arr[i-2] + arr[i-3]
    public static int result(int num) {
        //배열 = num까지의 정수
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=4; i<12; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }




        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int n1 = Integer.parseInt(br.readLine());
            System.out.println(result(n1));

        }

    }
}
