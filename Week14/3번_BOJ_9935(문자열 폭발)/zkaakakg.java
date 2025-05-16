import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean isCheck = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        isCheck = false;
                        break;
                    }
                }
                if (isCheck){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack){
            sb.append(c);
        }

        if(stack.size() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
    }

}
