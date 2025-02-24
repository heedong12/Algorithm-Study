import java.io.*;
import java.util.*;

//1.문자를 입력 받는다.
//2.정상, 리버스 형태로 저장한다.
//3.정상은 배열에 저장하고, 리버스로 저장한 배열에 문자가 있는지 확인한다.
//3.1. 배열에 저장하고 리버스로 확인하면 시작하자마자 정답이다. 확인하고 마지막에 저장한다.
//3.1.1. 아니다. 새벽에 풀어서 뇌가 절여졌다. 안해도 될 if를 돌려버렸다. 그냥 처음에 저장해도 된다.
//3.2. 배열쓰면 이중포문 해야할 것 같은데 마음에 안든다.
//3.3. 지가 앞뒤가 같은 문자열이면 출력하고 나온다.
//4.돌다가 찾으면 나온다. 출력하고 나온다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //단어의 수
//      String[] wordArr = new String[N]; // 단어 배열
        HashSet<String> wordSet = new HashSet<>(N); //단어 집합
        for(int i=0; i<N; i++) {
            String word = br.readLine();
            String wordReverse = new StringBuilder(word).reverse().toString();

            //3.1.1
            if(word.equals(wordReverse)){
                System.out.println(word.length() + " " + word.charAt(word.length()/2));
                break;
            }

            if(wordSet.contains(wordReverse)){
                System.out.println(word.length() + " " + word.charAt(word.length()/2));
                break;
            }
            //3.1.1
            wordSet.add(word);
        }
    }
}
