package gwonjihun.baekjjon;

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
		// 여기서 노드를 만들어 놨어 그러면 이제부터 dfs를 통해서 0부터 5에서갈수 있는 모든 노드들을 확인한다.
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
				//방문 처리로 트리의 방문 사이클 형성을 막는다.
				dfs(n_node.x,nextnode, weight + n_node.weight);

		}
	}
}
