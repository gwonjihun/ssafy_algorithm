package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16943 {
	static String a;
	static int b;
	static int c = Integer.MIN_VALUE;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		v = new boolean[a.length()];
		
		dfs(0,"");
		System.out.println(c==Integer.MIN_VALUE? -1: c);
	}
	static void dfs(int depth,String sum) {
		if(depth==a.length()) {
			int tc = Integer.parseInt(sum);
			if(tc<b) {
				c = Math.max(tc, c);
				return;
			}
		}
		for(int i = 0; i<a.length();i++) {
			if(v[i])continue;
			if(a.charAt(i)=='0'&&depth==0)continue;
			v[i]= true;
			dfs(depth+1,sum+a.charAt(i));
			v[i]=false;
		}
	}

}
