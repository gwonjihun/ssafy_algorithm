package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1707 {

	static List<List<Integer>> graph;
	static int[] color;
	static boolean[] visit;
	static final int red = 1;
	static int v,e;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			color = new int[v+1];
			for(int i = 0; i<v ; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0 ; i <e;i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			for(int i = 1 ; i <=v;i++) {
				if(color[i]==0) {
					
				}
			}
			
		}
	}
	
}
