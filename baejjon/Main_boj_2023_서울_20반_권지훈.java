package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 * */
public class Main_boj_2023_서울_20반_권지훈 {
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
        	// prime[i]�? ?��?��?���?
            if(!v[i]){
            	// prime[j] ?��?���? ?��?�� ?��?��
            	for(int j=i*i; j<=po-1; j+=i) v[j] = true;                
            }        
        }
	}
}
