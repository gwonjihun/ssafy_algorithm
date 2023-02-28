package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D4_3289_서울_20반_권지훈 {

	static int[] p;
	static int N, M;
	static void make(int N) {
		for(int i = 0 ; i <N; i++) p[i]= i;
	}
	
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	static boolean compare(int a, int b) {
		return find(p[a]) == find(p[b]) ;
	}
	
	static boolean union(int a,int b) {
		int aRoot= find(a);
		int bRoot = find(b);
		
		if(aRoot== bRoot) return false;
		
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=tc;t++) {
			int sw,S,E;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N];
			make(N);
			sb.append("#"+t+" ");
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine()," ");
				sw =  Integer.parseInt(st.nextToken());
				S =  Integer.parseInt(st.nextToken())-1;
				E =  Integer.parseInt(st.nextToken())-1;
				if(sw == 0 ) {
					union(S,E);
				}else {
					sb.append( compare(S,E)? 1:0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
