import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        int ansIdx = 0, boomIdx = 0, boomLen = boom.length;

        while (boomIdx < str.length) {
            str[ansIdx++] = str[boomIdx++];

            if (ansIdx >= boomLen) {
                int i = 0;

                for (; i < boomLen; i++) {
                    if (str[ansIdx - boomLen + i] != boom[i]) {
                        break;
                    }
                }

                if (i == boomLen) {
                    ansIdx -= boomLen;
                }
            }
        }

        System.out.println((ansIdx == 0) ? "FRULA" : new String(str, 0, ansIdx));
    }
}
