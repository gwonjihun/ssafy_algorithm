package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1289_20반_권지훈 {
	static int Test_case;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int T=1; T<=Test_case;T ++) {
			int result = 0;
			String input = br.readLine();
			char[] init = new char[input.length()];
			for(int i =0; i<init.length;i++) {
				init[i] = '0';
			}
			//여기서 문자열로 비교해서 동일하면 멈추게 해준다.
			//기존 배열에서랑 동일한 값이면 진행 안한다.
			
			for(int i =0; i<init.length;i++) {
				if(init[i] != input.charAt(i)) {
					int k = 1;
					if(init[i]=='1') {
						k *= -1;
					}					
					for(int j=i;j<init.length;j++) {
						init[j]+=k;
					}
					result++;
				}
			}
			sb.append("#").append(T).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}
}
