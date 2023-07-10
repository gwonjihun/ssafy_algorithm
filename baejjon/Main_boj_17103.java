package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17103 {
	static boolean[] v = new boolean[1_000_001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		prime();
		for(int t = 0 ; t< T;t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=2;i<N/2+1;i++) {
				if(!v[i]&&!v[N-i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	static void prime() {
		int len = 1000001;
		v[0]=v[1]=true;
		for(int i = 2;i*i <len;i++) {
			for(int j = i*i;j<len;j+=i) {
				v[j]= true;
			}
		}
	}
}
