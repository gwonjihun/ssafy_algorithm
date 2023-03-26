package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 * */
public class Main_boj_2023_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static boolean[] v;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int max = (int) Math.pow(10, N);
		v = new boolean[max];
		isprime(max);
		
		dfs("",0);
	}
	static void dfs(String s, int cnt) {
		if (cnt == N) {
			System.out.println(s);
			return;
		}
		
		for(int i =1;i<=9;i++) {
			if(!v[Integer.parseInt(s+i)]) {
				dfs(s+i,cnt+1);
			}
		}
	}
	static void isprime(int po) {
		v[0]=v[1]= true;
        for(int i=2; i*i<=po-1; i++){
        	// prime[i]ê°? ?†Œ?ˆ˜?¼ë©?
            if(!v[i]){
            	// prime[j] ?†Œ?ˆ˜ê°? ?•„?‹Œ ?‘œ?‹œ
            	for(int j=i*i; j<=po-1; j+=i) v[j] = true;                
            }        
        }
	}
}
