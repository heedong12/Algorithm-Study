import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();       // 원본 문자열
        String bomb = br.readLine();      // 폭발 문자열
        int bombLength = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLength) {
                boolean isSame = true;

                for (int j = 0; j < bombLength; j++) {
                    if (sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }

}
