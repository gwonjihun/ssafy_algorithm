package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1062 {
	static boolean[] alph; 
	static int max = Integer.MIN_VALUE
			;
	static int n,k;
	static String[] token;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		token = new String[n];
		alph = new boolean[26];
		alph['a'-'a'] = true;
		alph['n'-'a'] = true;
		alph['t'-'a'] = true;
		alph['i'-'a'] = true;
		alph['c'-'a'] = true;
		for(int i = 0 ; i<n;i++) {
			token[i] = br.readLine();
		}
		
		
		if(k<5) {
			//아무것도 못하쥬
			System.out.println(0);
		}else if(k== 26) {
			System.out.println(n);
		}
		else {
			//backtracking
			backtracking(0,0);
			System.out.println(max);
		}
	}
	
	static void backtracking(int alpha, int len) {
		if(len == k-5) {
			int count = 0;
			for(int i = 0 ;i<n;i++) {
				boolean flag = true;
				for(int j =0 ; j<token[i].length();j++) {
					if(!alph[token[i].charAt(j)-'a']) {
						flag = false;
						break;
					}
				}
				if(flag) count++;
			}
			max = Math.max(max, count);
			return;
		}
		
		for(int i = alpha; i<26;i++) {
			if(alph[i]==false) {
				alph[i]=true;
				backtracking(i+1, len+1);
				alph[i]=false;
			}
		}
		
		
	}
}
