import java.io.*;

public class Problem1062 {
	static int n , k;
	static String[] words; // 단어 목록
	static boolean[] visited = new boolean[26]; //알파벳 학습 여부
	static int max = Integer.MIN_VALUE; //최대 읽을 수 있는 단어 개수

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		words = new String[n];
		for(int i = 0; i < n; i++) {
			words[i] = br.readLine().replaceAll("anta|tica", "");
		}
		
		// 필수 문자 5개보다 적게 배우면 어떤 단어도 읽을 수 없음
		if(k < 5) { 
			System.out.println(0);
			return;
			
	    // k == 26이면 모든 알파벳을 배울 수 있으므로 모든 단어를 읽을 수 있음
		}else if(k == 26) {
			System.out.println(n);
			return;
		}
		
		// 필수 문자 체크
		visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        
        back(0,5);
        System.out.println(max);

	}
	
	// alpha : 현재 선택할 알파벳(0~25)
	// cnt : 현재까지 선택한 글자 개수	
	static void back(int alpha, int cnt) {
		// k개의 글자를 다 배운 경우 읽을 수 있는 단어 개수 계산
		if(cnt == k) {
			int temp = 0;
			for(int i = 0; i < n; i++) {
				boolean canRead = true;
				for(char c : words[i].toCharArray()) {
					if(!visited[c-'a']){ // 배우지 않은 글자가 포함되어 있으면 읽을 수 없음
						canRead = false;
						break;
					}
				}
				if(canRead) temp++;  // 읽을 수 있는 단어 개수 증가
			}
			
			max = Math.max(max,temp); // 최대값 갱신
			return;
		}
		
		// a~z까지의 알파벳을 하나씩 선택
		for(int i = alpha; i < 26; i++) {
            if (!visited[i]) { 
                visited[i] = true; 
                back(i + 1, cnt + 1); 
                visited[i] = false; 
            }
        }
	}
}
