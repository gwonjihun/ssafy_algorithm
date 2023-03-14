package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_11725_트리부모찾기 {
	static List<Integer>[] map;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N];
		for(int i = 0;i<N; i++) {
			map[i]= new ArrayList<Integer>();
		}
		for(int i = 1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int parent = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			map[child].add(parent);
			map[parent].add(child);
			
		}
		boolean[] v = new boolean[N];
		int[] parent = new int[N] ; // -> 값이 부모 도느
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		v[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int nnd : map[node]) {
				if(!v[nnd]) {
					v[nnd] = true;
					q.add(nnd);
					parent[nnd] = node;
				}
			}
		}
		
		for(int i = 1; i<N;i++)
			System.out.println(parent[i]+1);
	}
}
