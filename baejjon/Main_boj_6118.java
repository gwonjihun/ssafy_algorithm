package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_6118 {

	static int N, M;
	static int node, distance,cnt;
//	static ArrayList<Integer> list;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}

		bfs(1);
		
		System.out.println(node+" "+ distance+" "+cnt);
	}

	static void bfs(int start) {
		boolean[] v = new boolean[N + 1];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {1,0});
		v[1]=true;
		
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			int dist = arr[1];
			int st = arr[0];
			if(dist>distance) {
				distance = dist;
				node = st;
				cnt=1;
			}else if(dist == distance) {
				if(node>st) node = st;
				cnt++;
			}
			for(int next : graph[st]) {
				if(!v[next]) {
					v[next] = true;
					q.offer(new int[] {next, dist+1});
				}
			}
			
		}
		
	}
}
