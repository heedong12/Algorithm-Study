import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int size = 0;
        char middle = ' ';

        Map<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            hashMap.put(temp, temp);

            stb.append(temp).reverse();

            if (hashMap.containsKey(stb.toString())) {
                String answer = hashMap.get(stb.toString());
                size = answer.length();
                middle = answer.charAt(answer.length() / 2);
                break;
            }

            stb.setLength(0);
        }

        System.out.println(size + " " + middle);
    }
}
