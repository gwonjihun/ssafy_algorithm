package gwonjihun.baejjon;

import java.io.*;
import java.util.*;


public class Main_boj_2252_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static class Node{
		int vertex;
		Node link;
		Node(int vertex, Node link){
			this.link = link;
			this.vertex = vertex;
		}
	}
	static Node[] adjList;
	static int[] inDegree;
	
	static int N, M;
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		int from, to;
		for(int i = 0 ; i< M ; i++) {
			st= new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to= Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		for(int i : topologySort() ) {
			System.out.print(i+ " ");
		}
	}
	
	static ArrayList<Integer> topologySort(){
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = N; i>=1;i--) {
			if(inDegree[i] == 0 ) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			orderList.add(cur);
			
			for(Node temp = adjList[cur];temp!=null ; temp = temp.link) {
				if(--inDegree[temp.vertex] == 0 ) {
					q.offer(temp.vertex);
				}
			}
		}
		
		return orderList;
	}
}
