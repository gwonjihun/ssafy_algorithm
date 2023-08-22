package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2887 {

	private static class Node implements Comparable<Node> {
		int s, e, w;

		public Node(int s, int e, int w) {
			// TODO Auto-generated constructor stub
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return w - o.w;
		}

	}

	private static class Edge {
		int x, y, z,id;

		Edge(int x, int y, int z,int id) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.id = id;
		}
	}

	static int[] parent;
	static List<Node> nodes;
	static List<Edge> edges= new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i = 1 ; i <=N;i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < N;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(x,y,z,i+1));
			
		}
		nodes = new ArrayList<>();
		Collections.sort(edges,(p1,p2) -> p1.x-p2.x);
		for(int i =0; i<N-1;i++) {
			int w =  Math.abs(edges.get(i).x-edges.get(i+1).x);
			
			nodes.add(new Node(edges.get(i).id, edges.get(i+1).id, w));
		}
		
		Collections.sort(edges,(p1,p2) -> p1.y-p2.y);
		for(int i =0; i<N-1;i++) {
			int w =  Math.abs(edges.get(i).y-edges.get(i+1).y);
			
			nodes.add(new Node(edges.get(i).id, edges.get(i+1).id, w));
		}
		Collections.sort(edges,(p1,p2) -> p1.z-p2.z);
		for(int i =0; i<N-1;i++) {
			int w =  Math.abs(edges.get(i).z-edges.get(i+1).z);
			
			nodes.add(new Node(edges.get(i).id, edges.get(i+1).id, w));
		}
			
		Collections.sort(nodes);
		
		int ans = 0 ;
		for(int i = 0 ; i < nodes.size();i++) {
			Node cur = nodes.get(i);
			if(find(cur.s)!=find(cur.e)) {
				ans += cur.w;
				union(cur.s,cur.e);
			}
		} 
		
		System.out.println(ans);
	}
	
	static void union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			parent[x]=y;
		}
	}
	
	static int find(int x) {
		if(x == parent[x])return x;
		return parent[x]=find(parent[x]);
	}
}
