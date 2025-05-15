import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        int max = 0; // 결과

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                //board의 오른쪽과 다르면 교환
                if (j<N-1) {
                    if (board[i][j] != board[i][j+1]) {
                        char temp = board[i][j];
                        board[i][j] = board[i][j+1];
                        board[i][j+1] = temp;

                        max = Math.max(max, checkLength(board));

                        board[i][j+1] = board[i][j];
                        board[i][j] = temp;
                    }
                }
                //board의 아래쪽과 다르면 교환
                if (i<N-1) {
                    if (board[i][j] != board[i+1][j]) {
                        char temp = board[i][j];
                        board[i][j] = board[i+1][j];
                        board[i+1][j] = temp;

                        max = Math.max(max, checkLength(board));

                        board[i+1][j] = board[i][j];
                        board[i][j] = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int checkLength(char[][] board) {
        int N = board.length;
        int maxLength = 1;

        // 가로 길이 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                } else {
                    count = 1;
                }
            }
        }

        // 세로 길이 체크
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                } else {
                    count = 1;
                }
            }
        }

        return maxLength;
    }
}
