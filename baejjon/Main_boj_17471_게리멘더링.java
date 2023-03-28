package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17471_게리멘더링 {
	static class Node {
		int x;
		int people;

		Node(int x, int people) {
			this.x = x;
			this.people = people;
		}
	}

	static int n;
	static Node[] pos;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pos = new Node[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			int people = Integer.parseInt(st.nextToken());
			pos[i] = new Node(i, people);

		}
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {

			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= n / 2; i++) {
			comb(0, i, 1, new ArrayList<Integer>());
		}
	}

	static void comb(int cnt, int goal, int start, ArrayList<Integer> A_group) {
		if (cnt == goal) {
			solution(A_group);
			return;
		}
		for (int i = start; i <= n; i++) {
			A_group.add(i);
			comb(cnt + 1, goal, i + 1, A_group);
			A_group.remove(A_group.size() - 1);
		}
	}

	static void solution(ArrayList<Integer> A) {
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!A.contains(i)) {
				B.add(i);
			}
		}
		if(!bfs(A)) {
			return;
		}
		// b 객체도 만들어
		// 다음에 a의 연결성 유무를 확인하자
	}
	static boolean bfs(ArrayList<Integer> A) {
		
	}
}
