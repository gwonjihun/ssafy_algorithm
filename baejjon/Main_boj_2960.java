package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2960 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] list = new boolean[N+1];
		for(int i = 2;i<=N;i++) {
			list[i]=true;
		}
		for(int i = 2;i<=N;i++) {
			if(list[i]==false) continue;
			for(int j = i; j<=N;j+=i) {
				if(list[j]) {
					list[j]=false;
					M--;
					if(M==0) {
						System.out.println(j);
					}
				}
			}
		}
	
	}
	static boolean prime(int s) {
		for(int i =2;i<s;i++) {
			if(s%i==0) {
				return false;
			}
		}
		return true;
	}
}
