import java.io.*;

public class Main {
    static int max = 0, n;
    static char[][] map;

    static void swap(int x1, int y1, int x2, int y2) {
        char c = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = c;
    }

    static void checkCount() {
        for (int i = 0; i < n; i++) {
            int rowCnt = 1;
            int colCnt = 1;

            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    rowCnt++;
                } else {
                    rowCnt = 1;
                }

                if (map[j][i] == map[j + 1][i]) {
                    colCnt++;
                } else {
                    colCnt = 1;
                }

                max = Math.max(max, Math.max(rowCnt, colCnt));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] != map[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    checkCount();
                    swap(i, j, i, j + 1);
                }

                if (map[j][i] != map[j + 1][i]) {
                    swap(j, i, j + 1, i);
                    checkCount();
                    swap(j, i, j + 1, i);
                }
            }
        }

        System.out.println(max);
    }
}
