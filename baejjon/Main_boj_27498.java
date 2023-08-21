package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_27498 {

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
			return o.w - w;
		}
	}

	static int[] parent;
	static List<Node> nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 1;i<=N;i++) {
			parent[i] = i;
		}
		nodes = new ArrayList<>();
		int ans = 0;
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			if(f==0) {
				nodes.add(new Node(s,e,w));
				ans += w;
			}else {
				union(s, e);

				System.out.println(Arrays.toString(parent));
			}
			
		}
		Collections.sort(nodes);
		int cost = 0;
		for(int i = 0 ; i < nodes.size();i++) {
			Node cur = nodes.get(i);
			
			if(find(cur.s)!=find(cur.e)) {
				cost += cur.w;
				union(cur.s,cur.e);

				System.out.println(Arrays.toString(parent));
			}
		}
		System.out.println(ans-cost);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			parent[x]=y;
		}
	}
}
