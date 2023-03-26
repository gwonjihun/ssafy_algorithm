package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * Î®ºÏ? Î¨ºÍ≥†Í∏∞Î?? ?Éê?Éâ?ïú?ã§
 * ?Ç¥Í∞? Î®πÏùÑ ?àò ?ûà?äî Î¨ºÍ≥†Í∏∞Í? ?ûà?ã§Î©?
 * 
 * */
public class Main_boj_16236_?Ñú?ö∏_20Î∞?_Í∂åÏ??õà_refactoring {

	static class Node {
		int x;
		int y;
		int dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;

		}
	}

	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };

	static int[][] board;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		Deque<Node> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					q.addLast(new Node(i, j, 0));
					// ?ÉÅ?ñ¥ ?úÑÏπ? ???û•
					board[i][j] = 0;
				}
			}
		}
		int time = 0;
		int eat = 0, age = 2;
		while (true) {
			List<Node> fishs = new LinkedList<>();
			
			
			int dists[][] = new int[N][N];
			
			while (!q.isEmpty()) {
				Node cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				int dist = cur.dist;

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && dists[nx][ny] == 0 && board[nx][ny] <= age) {
						dists[nx][ny] = dist + 1;
						q.add(new Node(nx, ny, dist + 1));
						if (board[nx][ny] >= 1 && board[nx][ny] < age) {
							fishs.add(new Node(nx, ny, dist + 1));
						}
					}
				}
			}
			// ?úÑ ?èô?ûë?ÖáÎ•? ?Üµ?ï¥?Ñú bfsÎ•? ?Üµ?ï¥?Ñú Îß? ?†ÑÏ≤¥Ïóê ?ûà?äî ?Éù?Ñ†?ì§ Ï§? Î®πÏùÑ ?àò ?ûà?äî ?Éù?Ñ†?ùÑ fishs?óê ???û•?ï¥Ï£ºÏóàÍ≥?
			// ?ù¥?†ú?äî Î¶¨Ïä§?ä∏?óê ?ì§?ñ¥Í∞? ?ûà?äî Î¨ºÍ≥†Í∏∞Ï§ë?óê Ï°∞Í±¥?óê ÎßûÎäî Î¨ºÍ≥†Í∏∞Î?? ?Ñ†?Éù?ï¥?Ñú Î¨ºÍ≥†Í∏∞Î?? Î®πÍ≥† ?Çò?ù¥Î•? Í∞±Ïã†?ïòÍ≥?
			// Î®πÏ? ?í§?ùò ?ÉÅ?ñ¥ ?úÑÏπòÎ?? Í∏∞Î∞ò?úºÎ°? ?ã§?ãú distÍ∞íÏùÑ Í≥ÑÏÇ∞?ïòÍ∏? ?úÑ?ï¥?Ñú q?óê?ã§Í∞? ?ÉàÎ°úÏö¥ ?ÉÅ?ñ¥ ?úÑÏπòÎ?? push ?ï¥Ï§òÏïº?ïú?ã§.
			if (fishs.size() == 0) {
				System.out.println(time);
				break;
			}
			Node curfish = fishs.get(0);
			
			for (int i = 1; i < fishs.size(); i++) {
				if (curfish.dist > fishs.get(i).dist) {
					curfish = fishs.get(i);
				}else if(curfish.dist == fishs.get(i).dist){
					if(curfish.x>fishs.get(i).x) {
						curfish = fishs.get(i);
					}else if(curfish.x== fishs.get(i).x) { 
						if(curfish.y>fishs.get(i).y) {
						curfish = fishs.get(i);
					}
					}
				}
			}
			
			
			time+=curfish.dist;
			eat++;
			if(eat==age) {
				eat = 0;
				age++;
			}
			board[curfish.x][curfish.y] = 0;
			
			q.addLast(new Node(curfish.x, curfish.y,0));

		}

	}

}
