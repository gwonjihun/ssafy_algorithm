package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16637_괄호추가하기 {
	static int[] nums;
	static char[] chars;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N/2+1]; // 0 1 2 3 4
		chars = new char[N/2]; // 0 1 2 3
		int n_idx = 0 ;
		int c_idx = 0;
		char[] input = br.readLine().toCharArray();
		for(int i = 0; i < N ; i++) {
			if(i%2==0) {
				nums[n_idx++]= input[i]-'0';
			}else {
				chars[c_idx++]= input[i];
			}
		}
		//?��걸로 기호 ?��?�� 분리
		answer = Integer.MIN_VALUE;
		dfs(nums[0],0);
		
		System.out.println(answer);
	}
	static void dfs(int result,int chidx) {
		if(chidx>=chars.length) {
			answer = Math.max(result, answer);
			return;
			}
		int res1 = cal(result,chars[chidx],nums[chidx+1]);
		dfs(res1,chidx+1);
		
		if(chidx+1 < chars.length) {
			int res2 = cal(nums[chidx+1],chars[chidx+1],nums[chidx+2]);
			dfs(cal(result,chars[chidx],res2),chidx+2);
		}
		//괄호 ?��?�� 바로 계산 dfs
		//괄호 추�??��?�� dfs
	}
	static int cal(int result,char a,int num2 ) {
		switch(a) {
		case'+':
			return result+num2;
		case'-':
			return result-num2;
		case'*':
			return result*num2;
		case'/':
			return result/num2;
		}
		return -1;
	}
}
