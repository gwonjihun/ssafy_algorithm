package gwonjihun.swea;

import java.io.*;
import java.util.*;

class P {
	int x, y;
	int arrivalTime;// 계단 도착시간
	int stair;// 계단 종류
	int stairTime;// 계단을 내려가기 시작한 시각

	P(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setArrivalTime(S s) {
		arrivalTime = Math.abs(x - s.x) + Math.abs(y - s.y);
	}

}

class S {
	int x, y, k, cnt;

	S(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}

public class Solution_2383_점심시간 {

	static int N;
	static int[][] map;
	static ArrayList<P> pList;
	static ArrayList<S> sList;
	static boolean[] visited;
	static Queue<P>[] Q;
	private static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			pList = new ArrayList<>();
			sList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v == 1) {
						pList.add(new P(i, j));
					} else if (v != 0) {
						sList.add(new S(i, j, v));
					}
				}
			}

			ans = Integer.MAX_VALUE;
			Q = new LinkedList[2];
			Q[0] = new LinkedList<>();
			Q[1] = new LinkedList<>();

			go(0);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	private static void go(int level) {

		if (level == pList.size()) {
			visited = new boolean[pList.size()];
			int cur = simulation();
			ans = Math.min(cur, ans);
			return;
		}

		pList.get(level).stair = 0;
		pList.get(level).setArrivalTime(sList.get(0));
		go(level + 1);
		pList.get(level).stair = 1;
		pList.get(level).setArrivalTime(sList.get(1));
		go(level + 1);

	}

	private static int simulation() {
		int cnt = 0;
		int time = 0;

		while (true) {
			// Q안의 P중, 도착시간 + K가 현재시간과 같아지면, 제거한다.
			for (int i = 0; i < 2; i++) {
				int size = Q[i].size();

				for (int j = 0; j < size; j++) {
					P p = Q[i].poll();
					S s = sList.get(i);
					if (p.stairTime + s.k <= time)
						continue;

					Q[i].offer(p);
				}
			}

			if (cnt == pList.size() && Q[0].isEmpty() && Q[1].isEmpty()) {
				return time;
			}

			// Q안에 대기가 3개 미만이면 P를 넣어준다.
			for (int i = 0; i < pList.size(); i++) {
				P p = pList.get(i);
				Queue<P> q = Q[p.stair];
				if (visited[i])
					continue;
				//여기서 계단을 이용이 가능할때를 기점으로 time을 갱신해준다.
				if (p.arrivalTime + 1 <= time && q.size() < 3) {
					visited[i] = true;
					p.stairTime = time;
					q.offer(p);
					cnt++;
				}
			}
			time++;
		}
	}

}
