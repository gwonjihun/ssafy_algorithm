package gwonjihun.baejjon;
import java.io.*;
import java.util.*;

public class Main_1068_리프노드찾기 {
	
	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static boolean[] v;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0 ; i <n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		int start=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {start = i;
			continue;
			}
			graph.get(parent).add(i);
		}
		int idx = Integer.parseInt(br.readLine());
		graph.get(idx).clear();
		for(ArrayList<Integer> cur_n : graph) {
			if(cur_n.contains(idx))
			{
				cur_n.remove(new Integer(idx));
			}
			
		}
		v = new boolean[n];
		v[start] = true;
		if(idx != start) {
		
		dfs(start);
		
		}
		System.out.println(cnt);
	}
	static void dfs(int cur) {
		ArrayList<Integer> cur_n = graph.get(cur);
		if(cur_n.size()==0) {cnt++;}
		for(int a : cur_n) {
			if(v[a]) continue;
			v[a] =true;
			dfs(a);
			v[a] = false;
		}
	}
}
