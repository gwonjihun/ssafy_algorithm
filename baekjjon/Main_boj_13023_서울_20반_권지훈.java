package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_13023_서울_20반_권지훈 {
	
	static int N, M;
	static List<Integer>[] g;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		v = new boolean[N];
		M = Integer.parseInt(st.nextToken());
		g = new List[N];
		for(int i=0;i<N;i++) {
			g[i] = new ArrayList<>();
		}
		

		for(int i = 0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from].add(to);
			g[to].add(from);
		}
		
		for(int i =0;i<N;i++) {
			if(dfs(i,0)) {
//				System.out.println(i+"!@#!@#!@#12");
				System.out.println("1");
				return;
			}

		}
		System.out.println(0);
	}
	
	static boolean dfs(int s,int c) {
		if(c ==4) {
			return true;
		}
		v[s] = true;
		for(int i : g[s]) {
			if(!v[i]) {
//				System.out.println(i);
				if(dfs(i,c+1)) {

					return true;
				}
			}
		}
		v[s]=false;
		
		return false;
	}
}
