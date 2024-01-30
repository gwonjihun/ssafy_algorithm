package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2529_aga {
	static List<String> answer;
	static int N;
	static char[] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N];
		answer = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			map[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[10];
		for (int i = 9; i >=0; i--) {
			visited[i] = true;
			dfs(0, i, ""+i);
			visited[i] =false;
		}
		System.out.println(answer.get(0));
		System.out.println(answer.get(answer.size() - 1));
	}

	static void dfs(int depth, int last, String str) {
		// depth 깊이
		// str의 마지막 값을 가지고 간다고하면?
		if(depth == N) {
			answer.add(str);
			return;
		}
		
		for(int a=9;a>=0;a--) {
			if(visited[a])continue;
			if(map[depth]=='>') {
				if(last>a) {
					visited[a] = true;
					dfs(depth+1,a,str+a);
					visited[a] = false;
				}
			}else {
				if(last<a) {

					visited[a] = true;
					dfs(depth+1,a,str+a);

					visited[a] = false;
				}
			}
		}
	}
}
