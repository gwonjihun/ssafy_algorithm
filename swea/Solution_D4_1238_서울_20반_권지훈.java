package gwonjihun.swea;


import java.util.*;
import java.io.*;

public class Solution_D4_1238_서울_20반_권지훈 {
	static List<Integer>[] g;
	static boolean[] v = new boolean[101];
	static int N;
	static int Max_index=-1, Max_count=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int T=1; T<=10;T++) {
			Max_index=-1; Max_count=0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			g = new List[101];
			v = new boolean[101];
			for (int i = 0; i < 101; i++)
				g[i] = new ArrayList<>();
			for(int i=0;i<N/2;i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				g[s].add(e);
			}

			bfs(start);
			sb.append("#").append(T).append(" ").append(Max_index).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		v[start] = true;
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			if(xy[1]==Max_count) { Max_index = Math.max(Max_index, xy[0]);}
			else if(xy[1]>Max_count){
				Max_index = xy[0];
				Max_count = xy[1];
			}
			for(int i=0; i<g[xy[0]].size();i++) {
				if(!v[g[xy[0]].get(i)]) {
					q.add(new int[] {g[xy[0]].get(i), xy[1]+1});
					v[g[xy[0]].get(i)] = true;
				}
			}
		}
		
	}
}
