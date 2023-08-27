package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17472 {

	private static class Node implements Comparable<Node> {
		// mst를 위한 클래스
		int s, e, w;

		Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return w - o.w;
		}
	}

	static int[] parent;// mst 부모 표지
	static List<Node> nodes;// 다리 리스트
	static int[][] map; // 지도를 표시
	static boolean[][] visited;// 영역 표시했는지용, 경로 이동 확인
	static int n, m;
	static int cost=0, landcnt = 1;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		map = new int[n][m];
		// 초기 데이터 입력 끝
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기 데이터 기반 영역 분할

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					landcheck(i, j, landcnt++);
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		parent = new int[landcnt];
		for (int i = 1; i < landcnt; i++) {
			parent[i] = i;
		}
		// 다리 만들기

		nodes = new ArrayList<>();
//		int tmp = 0 ; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
//					tmp++;
					makebridge(i, j);
				}
			}
		}
//		System.out.println(tmp);
//		System.out.println(nodes.size());
		
		Collections.sort(nodes);
		for(int i = 0 ; i < nodes.size();i++) {
			Node cur = nodes.get(i);
			if(find(cur.s)!=find(cur.e)) {
				union(cur.s, cur.e);
				cost+= cur.w;
			}
		}
//		System.out.println(Arrays.toString(parent));
		
		for(int i = 1;i<parent.length;i++) {
			find(i);
//			if(parent[i]!=parent[i+1]) {
//				System.out.println(-1);
//				System.exit(0);
//			}
		}
		for(int i = 1;i<parent.length-1;i++) {
//			find(i);
			if(parent[i]!=parent[i+1]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
//		System.out.println(Arrays.toString(parent));
		System.out.println(cost!=0? cost : -1);
	}
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x]=find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			parent[x]=y;
		}
	}
	static void makebridge(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		visited = new boolean[n][m];
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			q.add(new int[] { x, y, 0 });
			while (!q.isEmpty()) {
				int[] cur = q.poll();

				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
					if (map[nx][ny] != map[x][y]) {
						// 여기서부턴이제 다리이냐 or 땅이냐만 판독해준다
						if (map[nx][ny] != 0) {
							// 여긴 땅이란 의미이닌깐
							if (cur[2] > 1) {
								nodes.add(new Node(map[x][y], map[nx][ny], cur[2]));
							} 
						}else {
							q.add(new int[] { nx, ny, cur[2] + 1 });
							visited[nx][ny] = true;
						}

					}
				}
			}
			q.clear();
		}
	}

	static void landcheck(int x, int y, int idx) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = idx;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
					q.add(new int[] { nx, ny });
					visited[nx][ny] = true;
					map[nx][ny] = idx;
				}
			}
		}
	}
}
