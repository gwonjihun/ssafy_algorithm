package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_5567 {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] v;
	static int cnt = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i = 0 ; i < N+1;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ; i < M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		v = new boolean[N+1];
		v[1]=true;
		dfs(1,0);
		for(boolean s : v) {
			if(s)cnt++;
		}
		System.out.println(cnt);
	}
	static void dfs(int start, int depth) {
		if(depth==2) {
			return;
		}
		ArrayList<Integer> tmp = graph[start];
		for(int i=0;i<tmp.size();i++) {
			int a = tmp.get(i);
//			System.out.println(a);
//			if(!v[a]) {
			v[a]= true;
//			cnt++;
			dfs(a,depth+1);
//			}
		}
	}
}
