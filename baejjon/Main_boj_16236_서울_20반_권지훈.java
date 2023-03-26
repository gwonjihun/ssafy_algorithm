package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * ë¨¼ì? ë¬¼ê³ ê¸°ë?? ?ƒ?ƒ‰?•œ?‹¤
 * ?‚´ê°? ë¨¹ì„ ?ˆ˜ ?ˆ?Š” ë¬¼ê³ ê¸°ê? ?ˆ?‹¤ë©?
 * 
 * */
public class Main_boj_16236_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static class node {
		int x;
		int y;
		int c; // ?˜„?¬ ?ƒ?–´ê°? ?ˆ?Š” ?œ„ì¹˜ë¡œë¶??„°?˜ ê±°ë¦¬

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
			// bfsë¡? ë¬¼ê³ ê¸°ë“¤?˜ ?œ„ì¹˜ë?? ê°?? ¸??ì£¼ê³ 
			// ê±°ë¦¬?¼?Š” 2ì°¨ì› ë°°ì—´?´ ?•„?š”?•˜?‹¤
			// ?™œ?ƒ?•˜ë©? ë¬¼ê³ ê¸°ë“¤ë§ˆë‹¤?˜ ?ƒ?–´???˜ ê±°ë¦¬ë¥? êµ¬í•œê²ƒì„ ???¥?•  ?„?‹œ ë³??ˆ˜ê°? ?•„?š”?•¨
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
			} // ?—¬ê¸°ë?? ?†µ?•´?„œ ?˜„?¬ ?ƒ?–´ ?œ„ì¹˜ë?? ê¸°ì??œ¼ë¡? ê°? ë°°ì—´ê¹Œì? ê°??Š” ê±°ë¦¬ë¥? dist?— ???¥?•˜ë©´ì„œ ë¨¹ì„?ˆ˜ ?ˆ?Š” fishë¥? ì¡°ê±´?— ë§ëŠ” ?ˆœ?„œ??ë¡?
				// ?„£?–´?†¨?‹¤.
				// ?´? œ ?—¬ê¸°ì„œë¶??„° ì§„í–‰?•˜?Š” ë°©ë²•??
				// fish?—?„œ ?•˜?‚˜ë¹¼ì„œ ë¨¹ê³  ?•´?‹¹ ?œ„ì¹˜ë¡œ ?ƒ?–´ê°? ?´?™?•˜ê³??
				// ?´? œë¶??„° ë¨¹ì„ ?ˆ˜ ?ˆ?Š” ë¬¼ê³ ê¸? ë¦¬ìŠ¤?Š¸ë¥? ? „ì²? ?ƒ?ƒ‰?•˜ë©´ì„œ ê±°ë¦¬ê°? ê°??¥ ì§§ê³  ê°??¥ ?œ„?— ê°??¥ ?™¼ìª½ì— ?ˆ?Š” ???„?„ ê³¨ë¼ì¤??‹¤.
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
			//?—¬ê¸°ì„œ ?´? œ ìµœì¢…? ?œ¼ë¡? currentfishë¥? ?„ ?ƒ?•˜??ê³?
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
