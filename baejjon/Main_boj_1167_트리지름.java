package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_1167_트리지름 {
	static class Node {
		int x;
		int weight;

		Node(int x, int weight) {
			this.x = x;
			this.weight = weight;
		}
	}
	static ArrayList<Node>[] graph;
	static int N;
	static int Min_answer = Integer.MIN_VALUE;
	static int Max_node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i = 0 ; i<N+1;i++) graph[i] = new ArrayList<Node>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken()) ;
			while (true) {
				int next = Integer.parseInt(st.nextToken()) ;
				if (next == -1) break;
				int wegiht = Integer.parseInt(st.nextToken());
				graph[parent].add(new Node(next, wegiht));
			}
		}
		// ?��기서 ?��?���? 만들?�� ?��?�� 그러�? ?��?���??�� dfs�? ?��?��?�� 0�??�� 5?��?��갈수 ?��?�� 모든 ?��?��?��?�� ?��?��?��?��.
		dfs(4,0, 0);
		dfs(Max_node,0, 0);
		System.out.println(Min_answer);

	}

	static void dfs(int nextnode,int prnode, int weight) {
		if (Min_answer < weight) {
			Max_node = nextnode;
			Min_answer = weight;
		}
		for (int i = 0; i < graph[nextnode].size(); i++) {

			Node n_node = graph[nextnode].get(i);
			if (prnode == n_node.x) {continue;}
				//방문 처리�? ?��리의 방문 ?��?��?�� ?��?��?�� 막는?��.
				dfs(n_node.x,nextnode, weight + n_node.weight);

		}
	}
}
