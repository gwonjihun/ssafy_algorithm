package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D4_7465_서울_20반_권지훈 {
	// 1번 루프를 돌고있으면 1개
	// 2번 다른 최상단 노드를 가르키면 result에 저장된 최상단 노드 리스트와 비교하여서 cnt ++
	static int[] p;
	static boolean[] v;
	static int cnt = 0;

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}
	
	static void make(int N) {
		for(int i = 0 ; i < N ; i++) p[i] =i;
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		p[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= Tc; T++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N];
			make(N);
			v = new boolean[N];
			for (int c = 0; c < M; c++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken())-1;
				int en = Integer.parseInt(st.nextToken())-1;
				union(s,en);
			}
			
			for (int i = 0; i < N; i++) {
				find(i);
			}
			for (int i = 0; i < N; i++) {
				if(v[p[i]]) continue;
				v[p[i]] = true;
				cnt++;
			}
			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
