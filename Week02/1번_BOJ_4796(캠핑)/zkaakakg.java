import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		while(true) {
			String[] input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			int p = Integer.parseInt(input[1]);
			int v = Integer.parseInt(input[2]);
			
			if(l==0 && p==0 && v==0) break;
			
			int result = (v/p) * l + Math.min(v%p, l);
			cnt++;
			sb.append("Case ").append(cnt).append(": ").append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}
