import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int[][] room = new int[15][15];
        for (int i = 1; i < 15; i++) {
            room[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            room[i][1] = 1;
            for (int j = 2; j < 15; j++) {
                room[i][j] = room[i-1][j] + room[i][j-1];
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            stb.append(room[k][n]).append("\n");
        }

        System.out.println(stb.toString());
    }
}
