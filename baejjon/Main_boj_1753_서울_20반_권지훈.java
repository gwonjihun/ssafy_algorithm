package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1753_서울_20반_권지훈 {

	static final int INF = Integer.MAX_VALUE;
	static List<int[]>[] g;
	static int[] dist;
	static boolean[] v;
	static int V, E;
	static int start;
	
	public static void sol(int start) {
		dist = new int[V];
		v = new boolean[V];
		Arrays.fill(dist, INF);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1], o2[1]));
		
		pq.offer(new int[] {start,0});
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int now = pq.poll()[0];
			
			if(v[now]) continue;
			
			v[now]= true;
			for(int i = 0 ; i<g[now].size(); i++) {
				int next = g[now].get(i)[0];
				int cost = g[now].get(i)[1];
				
				if(dist[now]+cost < dist[next]) {
					dist[next] = dist[now]+cost;
					pq.offer(new int[] {next,dist[next]});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		g = new ArrayList[V];
		start = Integer.parseInt(br.readLine())-1;

		for(int i=0; i<V; i++) g[i] = new ArrayList<>();
		
		
		for(int i = 0 ; i < E ; i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
		
			g[a].add(new int[] {b,c});
		}
		
		sol(start);
		
		for(int s : dist) {
			sb.append(s==INF? "INF":s).append("\n");
		}
		System.out.println(sb);
	}
}