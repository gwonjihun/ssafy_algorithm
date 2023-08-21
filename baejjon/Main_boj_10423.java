package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10423 {

	private static class Node implements Comparable<Node> {
		int s, e, w;

		Node(int s, int e, int w) {
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
	static int[] parent;
	static List<Node> nodes;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i]=i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			parent[tmp]=-1;
		}
		nodes = new ArrayList<>();
		for(int i=0;i<M;i++) {

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
		
		
			nodes.add(new Node(s,e,w));
			
		}
		
		Collections.sort(nodes);
		int ans = 0 ; 
		for(int i = 0 ; i <nodes.size();i++){
			Node cur = nodes.get(i);
			
			if(find(cur.s)!=find(cur.e)) {
				ans += cur.w;
				
				union(cur.s, cur.e);
				
				if(isconnect()) {
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean isconnect() {
		for(int i = 1 ; i < parent.length;i++) {
			if(parent[i]!=-1) return false;
		}
		return true;
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		if(parent[x] == -1) return -1;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x !=y) {
			if(x==-1) {
				parent[y] = x;
			}
			else if( y== -1 ) {
				parent[x]= y;
			}else {
				parent[y]=x;
			}
		}
		
		
	}
}
