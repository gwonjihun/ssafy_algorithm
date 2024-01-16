package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1759_aga {
	
	static char[] arr;
	static char[] answer;
	static boolean[] visited;
	static int N,M;
	static char[] check = {'a','e','i','o','u'};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new char[N];
		arr = new char[M];
		visited = new boolean[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <M;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		perm(0,0);
		
	}
	static void perm(int idx,int depth) {
		if(depth==N) {
			if(check()) {
				for(char a : answer) {
					System.out.print(a);
				}
				System.out.println();
			}
			return;
		}
		for(int i = idx ; i <M ;i++) {
			answer[depth] = arr[i];
			perm(i+1,depth+1);
		}
		
	}
	static boolean check() {
		int s = 0;//모음
		int c = 0;//자음
		for(char a : answer) {
			boolean flag = false;
			for(char b : check) {
				if(a==b) { flag = true;
				break;}
			}
			if(flag ) {
				s++;
			}else {
				c++;
			}
		}
		
		return (s>=1 && c>1);
	}
	
}
