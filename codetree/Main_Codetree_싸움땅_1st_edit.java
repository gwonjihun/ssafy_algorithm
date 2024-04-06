package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_Codetree_싸움땅_1st_edit {
	// 이걸 기반으로 해서 num분에 나온 사람임을 알려주고
	private static class Node {
		int x;
		int y;
		int num;// 몇번째 사람인지를 알아야하닌깐.

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	private static class Goal {
		int x;
		int y;

		Goal(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
	static ArrayList<Goal> shopList = new ArrayList<>();
	// goal의 x,y가 0,0이 되면 도착했음을 의미해주는거지

	static ArrayDeque<Node> que = new ArrayDeque<>();
	// 처음에 돌릴떄마다 q.size를 기반으로 돌려준다.
	static final int Max_n = 16;
	// 1~15까지만 사용한다.
	static int[][] basecamp = new int[Max_n][Max_n];

	static boolean[][][] visited;
	// 최단거리를 위한 방문처리

	static int n, m;
	static int fm;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		// 1~n까지 이동가능하게해놨으닌깐...
		m = Integer.parseInt(st.nextToken());
		// num또한 0번부터 m-1번으로할꺼닌깐

		visited = new boolean[m][Max_n][Max_n];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				basecamp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			shopList.add(new Goal(x, y));
		}
		fm= m;
		time = 0;
		while (fm>0) {
			time++;
			move();
			boolean check = true;

			if (time <= m) {
//	                System.out.println("test");
				insert();//
			}

		}
		System.out.println(time);

	}

	static void move() {
		int size = que.size();
		for (int i = 0; i < size; i++) {
			// 여기서 이제 q size만큼만 돌린다.
			Node cur = que.poll();
			int idx = cur.num;
			Goal a = shopList.get(idx);
			if (a.x == -1 && a.y == -1)
				continue;

			int x = cur.x;
			int y = cur.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (0 < nx && nx <= n && 0 < ny && ny <= n && !visited[idx][nx][ny] && basecamp[nx][ny] != -1) {
					if (a.x == nx && a.y == ny) {

						basecamp[nx][ny] = -1;
						a.x = -1;
						a.y = -1;
						fm--;
					}
					visited[idx][nx][ny] = true;
					que.add(new Node(nx, ny, idx));
				}

			}
		}
	}

	static void insert() {
		boolean[][] visit = new boolean[n + 1][n + 1];
		Goal start = shopList.get(time - 1);
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { start.x, start.y });
		visit[start.x][start.y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (0 < nx && nx <= n && 0 < ny && ny <= n && !visit[nx][ny] && basecamp[nx][ny] != -1) {
					if (basecamp[nx][ny] == 1) {
						que.add(new Node(nx, ny, time - 1));

						System.out.println(nx + " " + ny + " " + (time-1));
						basecamp[nx][ny] = -1;
						visited[time - 1][nx][ny] = true;
						return;
					}
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
		// insert는 어떻게 할꺼냐면 time값을 기반으로
	}
}