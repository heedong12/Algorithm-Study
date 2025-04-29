import java.io.*;

public class Main {
    static int[] myData;
    static int[] min;

    static boolean checkCount() {
        for (int i = 0; i < 4; i++) {
            if (myData[i] < min[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        char[] dna = br.readLine().toCharArray();

        input = br.readLine().split(" ");
        min = new int[4];
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(input[i]);
        }

        myData = new int[4];
        for (int i = 0; i < p; i++) {
            if (dna[i] == 'A') {
                myData[0]++;
            } else if (dna[i] == 'C') {
                myData[1]++;
            } else if (dna[i] == 'G') {
                myData[2]++;
            } else if (dna[i] == 'T') {
                myData[3]++;
            }
        }

        int cnt = checkCount() ? 1 : 0;

        for (int i = 0, j = p; j < s; i++, j++) {
            if (dna[i] == 'A') {
                myData[0]--;
            } else if (dna[i] == 'C') {
                myData[1]--;
            } else if (dna[i] == 'G') {
                myData[2]--;
            } else if (dna[i] == 'T') {
                myData[3]--;
            }

            if (dna[j] == 'A') {
                myData[0]++;
            } else if (dna[j] == 'C') {
                myData[1]++;
            } else if (dna[j] == 'G') {
                myData[2]++;
            } else if (dna[j] == 'T') {
                myData[3]++;
            }

            cnt += checkCount() ? 1 : 0;
        }

        System.out.println(cnt);
    }
}
