package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

/*
 * 먼저 물고기를 탐색한다
 * 내가 먹을 수 있는 물고기가 있다면
 * 
 * */
public class Main_boj_16236_서울_20반_권지훈 {
	static class node {
		int x;
		int y;
		int c; // 현재 상어가 있는 위치로부터의 거리

		node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
	static int time;
	static int eat = 0, age = 2;
	static int[][] board;
	static int N;

	public static void main(String[] args) throws Exception {
		Deque<int[]> q = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		time = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					q.add(new int[] { i, j, 0 });
					board[i][j] = 0;
				}
			}
		}

		while (true) {
			List<node> fish = new ArrayList<>();
			// bfs로 물고기들의 위치를 가져와주고
			// 거리라는 2차원 배열이 필요하다
			// 왜냐하면 물고기들마다의 상어와의 거리를 구한것을 저장할 임시 변수가 필요함
			int[][] dist = new int[N][N];
			while (!q.isEmpty()) {
				int[] xyd = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = xyd[0] + dx[d];
					int ny = xyd[1] + dy[d];
					int dis = xyd[2];

					if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] <= age && dist[nx][ny] == 0) {
						dist[nx][ny] = dis + 1;
						q.addLast(new int[] { nx, ny, dist[nx][ny] });
						if (board[nx][ny] >= 1 && board[nx][ny] < age) {
							fish.add(new node(nx, ny, dist[nx][ny]));
						}
					}

				}
			} // 여기를 통해서 현재 상어 위치를 기준으로 각 배열까지 가는 거리를 dist에 저장하면서 먹을수 있는 fish를 조건에 맞는 순서대로
				// 넣어놨다.
				// 이제 여기서부터 진행하는 방법은
				// fish에서 하나빼서 먹고 해당 위치로 상어가 이동하고?
				// 이제부터 먹을 수 있는 물고기 리스트를 전체 탐색하면서 거리가 가장 짧고 가장 위에 가장 왼쪽에 있는 녀석을 골라준다.
			if (fish.size() == 0) {
				break;
			}
			node currentfish = fish.get(0);

			for (int i = 1; i < fish.size(); i++) {
				node next = fish.get(i);
				if (currentfish.c > next.c) {
					currentfish = next;
					continue;
				}
				if (currentfish.c == next.c) {
					if (currentfish.x > next.x) {
						currentfish = next;
					} else if (currentfish.x == next.x) {
						if(currentfish.y> next.y) {
							currentfish = next;
						}
					}
				}
			}
			//여기서 이제 최종적으로 currentfish를 선택하였고
			time+=currentfish.c;
			eat++;
			if(eat==age) {
				eat = 0;
				age++;
			}
			board[currentfish.x][currentfish.y] = 0;
			
			q.add(new int[] {currentfish.x, currentfish.y,0});

			
			

		}
		System.out.println(time);
	}

	

}
