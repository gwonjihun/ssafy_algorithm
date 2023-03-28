package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 먼�? 물고기�?? ?��?��?��?��
 * ?���? 먹을 ?�� ?��?�� 물고기�? ?��?���?
 * 
 * */
public class Main_boj_16236_서울_20반_권지훈 {
	static class node {
		int x;
		int y;
		int c; // ?��?�� ?��?���? ?��?�� ?��치로�??��?�� 거리

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
			// bfs�? 물고기들?�� ?��치�?? �??��??주고
			// 거리?��?�� 2차원 배열?�� ?��?��?��?��
			// ?��?��?���? 물고기들마다?�� ?��?��???�� 거리�? 구한것을 ???��?�� ?��?�� �??���? ?��?��?��
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
			} // ?��기�?? ?��?��?�� ?��?�� ?��?�� ?��치�?? 기�??���? �? 배열까�? �??�� 거리�? dist?�� ???��?��면서 먹을?�� ?��?�� fish�? 조건?�� 맞는 ?��?��??�?
				// ?��?��?��?��.
				// ?��?�� ?��기서�??�� 진행?��?�� 방법??
				// fish?��?�� ?��?��빼서 먹고 ?��?�� ?��치로 ?��?���? ?��?��?���??
				// ?��?���??�� 먹을 ?�� ?��?�� 물고�? 리스?���? ?���? ?��?��?��면서 거리�? �??�� 짧고 �??�� ?��?�� �??�� ?��쪽에 ?��?�� ???��?�� 골라�??��.
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
			//?��기서 ?��?�� 최종?��?���? currentfish�? ?��?��?��??�?
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
